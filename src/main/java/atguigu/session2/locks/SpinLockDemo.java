package atguigu.session2.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
//手写实现自旋锁
public class SpinLockDemo {
    //原子引用装线程Thread：保证原子性
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void myLock() {
        //获取当前线程
        Thread CurrentThread = Thread.currentThread();
        System.out.println(CurrentThread.getName() + "：加锁");
        //手写自旋锁,现在线程≠null,让其一直循环等待其他线程
        while (!atomicReference.compareAndSet(null, CurrentThread)) {

        }
    }

    public void unMyLock() {
        Thread CurrentThread = Thread.currentThread();
        atomicReference.compareAndSet(CurrentThread, null);
        System.out.println(CurrentThread.getName() + "：解锁");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            //线程一加锁
            spinLockDemo.myLock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //线程二解锁
            spinLockDemo.unMyLock();
        }, "线程一").start();

        //等待让线程二进入
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            //线程二加锁
            spinLockDemo.myLock();
            //线程二解锁
            spinLockDemo.unMyLock();
        }, "线程二").start();

    }
}
