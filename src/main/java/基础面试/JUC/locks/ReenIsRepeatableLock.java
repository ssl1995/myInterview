package 基础面试.JUC.locks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resources implements Runnable {

    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        method1();
    }

    // 补充：加锁几次和解锁几次必须配对，如果配对都会生效
    private void method1() {
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ",进入method1");
        method2();
        lock.unlock();
        lock.unlock();
    }

    private void method2() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ",进入method2");
        lock.unlock();
    }
}

public class ReenIsRepeatableLock {
    public static void main(String[] args) {
        Resources resources = new Resources();
        Thread t1 = new Thread(resources);
        Thread t2 = new Thread(resources);
        t1.start();
        t2.start();
    }
}
