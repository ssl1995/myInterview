package atguigu.session2.blockingQueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//传统版资源类：高类聚=自带消费者和生产者
class ShareData {
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    //生产者
    public void increment() throws Exception {
        lock.lock();
        try {
            //1 判断 num!=0就等待生产
            //多线程使用while，不用if防止虚假唤醒
            while (num != 0){
                condition.await();
            }
            //2 干活
            num++;
            System.out.println(Thread.currentThread().getName() + "\tnum值：" + num);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    //消费者
    public void decrement() throws Exception {
        lock.lock();
        try {
            //1 判断 多线程是while判断
            while (num == 0) {
                condition.await();
            }
            //2 干活：消费
            num--;
            System.out.println(Thread.currentThread().getName() + "\tnum值：" + num);
            //3 通知唤醒
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}