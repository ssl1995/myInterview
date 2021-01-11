package atguigu.session2.locks.deadLock;

import java.util.concurrent.TimeUnit;

public class DeadThreadDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadThread(lockA, lockB), "A").start();
        //lockA和lockB互换
        new Thread(new DeadThread(lockB, lockA), "B").start();


    }
}

class DeadThread implements Runnable {
    String lockA;
    String lockB;

    public DeadThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockA + ",想持有" + lockB);
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t 自己持有" + lockB + ",想持有" + lockA);
            }
        }
    }
}
