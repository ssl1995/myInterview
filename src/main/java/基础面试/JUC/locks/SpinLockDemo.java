package 基础面试.JUC.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

class MyResource {

}

public class SpinLockDemo {

    AtomicReference<MyResource> atomicReference = new AtomicReference<>();
    MyResource myResource = new MyResource();

    private void method1() {
        System.out.println(Thread.currentThread().getName() + ",加锁啦");
        while (!atomicReference.compareAndSet(null, myResource)) {

        }

    }

    private void method2() {
        atomicReference.compareAndSet(myResource, null);
        System.out.println(Thread.currentThread().getName() + ",解锁啦");
    }

    public static void main(String[] args) {
        SpinLockDemo demo = new SpinLockDemo();
        new Thread(() -> {
            demo.method1();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            demo.method2();
        }, "线程1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            demo.method1();
            demo.method2();
        }, "线程2").start();

    }

}
