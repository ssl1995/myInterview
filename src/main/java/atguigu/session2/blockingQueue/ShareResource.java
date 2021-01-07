package atguigu.session2.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Syn和Lock区别的资源类
class ShareResource {
    //1=AA,2=BB,3=CC
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();


    public void print5() {
        lock.lock();
        try {
            //1 判断 防止虚假唤醒，使用while
            while (number != 1) {
                //不等于1 就不是AA干活，AA等待
                c1.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            number = 2;
            c2.signal();

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
            while (number != 2) {
                //不等于1 就不是AA干活，AA等待
                c2.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            number = 3;
            c3.signal();

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
            while (number != 3) {
                //不等于1 就不是AA干活，AA等待
                c3.await();
            }
            //2 干活 模拟打印5次
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知别的线程
            number = 1;
            c1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}