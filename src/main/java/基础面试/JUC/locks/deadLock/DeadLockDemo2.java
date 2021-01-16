package 基础面试.JUC.locks.deadLock;


public class DeadLockDemo2 {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";

        new Thread(new DeadThread(lockA, lockB), "A").start();
        //lockA和lockB互换
        new Thread(new DeadThread(lockB, lockA), "B").start();

    }
}

