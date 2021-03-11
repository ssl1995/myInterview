package ssl.JUC.learnVolatile;

import java.util.concurrent.TimeUnit;

public class VolatileDemo {
    public static void main(String[] args) {
        atomicByAtomicInteger();
    }

    // 不保证原子性：使用javap -c反编译查看原因
    private static void atomicByAtomicInteger() {
        // 1.资源类
        ssl.JUC.learnVolatile.MyResources myResources = new ssl.JUC.learnVolatile.MyResources();
        // 2.atomicInteger保证原子性
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myResources.add1();
                    myResources.addByAtomic();
                }
            }, String.valueOf(i)).start();
        }
        // 3.默认的2个线程是main和GC，所以让大于这个2个线程的等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ",data:" + myResources.data);
        System.out.println(Thread.currentThread().getName() + ",atomicInteger:" + myResources.atomicInteger);
    }

    // 不保证原子性：使用javap -c反编译查看原因
    private static void NotAtomicByVolatile() {
        // 1.资源类
        ssl.JUC.learnVolatile.MyResources myResources = new ssl.JUC.learnVolatile.MyResources();
        // 2.模拟volatile不保证原子性
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    myResources.add1();
                }
            }, String.valueOf(i)).start();
        }
        // 3.默认的2个线程是main和GC，所以让大于这个2个线程的等待
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        // 4.volatile修饰的共享变量，不能保证原子性
        System.out.println(Thread.currentThread().getName() + ",data:" + myResources.data);
    }

    // 保证可见性Demo
    private static void seeOkByVolatile() {
        ssl.JUC.learnVolatile.MyResources myResources = new ssl.JUC.learnVolatile.MyResources();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ",进入啦");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
            myResources.add();
            System.out.println(Thread.currentThread().getName() + ",已经修改data：" + myResources.data);
        }, "线程A").start();

        while (myResources.data == 0) {
            /*    System.out.println(Thread.currentThread().getName() + ",while等待");*/
        }

        System.out.println(Thread.currentThread().getName() + ",模拟结束,data:" + myResources.data);
    }


}
