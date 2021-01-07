package atguigu.session2.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁：指多个线程按照访问顺序来获取锁， = 排队打饭，先来先得
 *
 * 非公平锁：后申请的线程比先申请的线程优先获得锁，在高并发下有可能造成优先级反转/饥饿现象
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        //ReentrantLock()空参就是非公平锁
        ReentrantLock lock1 = new ReentrantLock();
        //ReentrantLock(true):公平锁,性能下降，但是顺序得到保障
        ReentrantLock lock2 = new ReentrantLock(true);
    }
}
