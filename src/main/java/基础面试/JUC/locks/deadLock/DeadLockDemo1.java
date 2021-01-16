package 基础面试.JUC.locks.deadLock;

public class DeadLockDemo1 {
    // 资源1，让线程1获得
    private static Object resource1 = new Object();
    // 资源2，让线程2获得
    private static Object resource2 = new Object();

    public static void main(String[] args) {
        // 线程1
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + ":get resource1");
                // 线程1等待1s，让线程2获得资源2
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + ":get resource2");
                }
            }
        }, "线程 1").start();
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + ":get resource2");
                // 线程2等待1s，让线程1获得资源1
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + ":get resource1");
                }
            }
        }, "线程 2").start();
    }
}
