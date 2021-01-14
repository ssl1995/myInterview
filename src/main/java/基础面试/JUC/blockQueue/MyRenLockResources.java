package 基础面试.JUC.blockQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Syn和Lock区别的资源类
class MyRenLockResources {
    // 1=AA,2=BB,3=CC
    private int threadName = 1;
    private Lock lock = new ReentrantLock();
    //
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();


    public void print5() {
        lock.lock();
        try {
            //1 判断 防止虚假唤醒，使用while
            while (threadName != 1) {
                //不等于1 就不是AA干活，AA等待
                a.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            threadName = 2;
            b.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1 判断 防止虚假唤醒，使用while
            while (threadName != 2) {
                //不等于1 就不是AA干活，AA等待
                b.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            threadName = 3;
            c.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1 判断 防止虚假唤醒，使用while
            while (threadName != 3) {
                //不等于1 就不是AA干活，AA等待
                c.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            threadName = 1;
            a.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}