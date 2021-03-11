package ssl.JUC.locks;


import java.util.concurrent.TimeUnit;

class Phone {
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + ",进入method1");
        method2();
    }

    private synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + ",进入method2");

    }
}

public class SynIsRepeatableLock {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.method1();
        }, "线程1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {
            phone.method1();
        }, "线程2").start();
    }
}

