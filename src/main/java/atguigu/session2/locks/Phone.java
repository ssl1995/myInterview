package atguigu.session2.locks;


import java.util.concurrent.locks.ReentrantLock;

public class Phone implements Runnable {

    // synchronized：是可重入锁
    public synchronized void sendMSG() {
        System.out.println(Thread.currentThread().getName() + "：手机发消息了");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "：手机发邮件了");
    }

    // ReentrantLock:是可重入锁
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        get();
    }

    private void get() {
        //面试加问：加2层锁，也是成功的，说明只要加锁和解锁匹配就行
        lock.lock();
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":进入了get方法");
        get1();
        lock.unlock();
        lock.unlock();
    }

    private void get1() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + ":进入了get1方法");
        lock.unlock();
    }
}
