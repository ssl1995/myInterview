package ssl.JUC.blockQueue;

/*
 sync和lock的区别题目：
    多线程之间按顺序调用，实现A-B-C三个线程启动，要求如下：
     AA打印5次，BB打印10次，CC打印15次，紧接着AA打印5次，...重复10论
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ssl.JUC.blockQueue.MyRenLockResources myResources = new ssl.JUC.blockQueue.MyRenLockResources();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myResources.print5();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myResources.print10();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                myResources.print15();
            }
        }, "CC").start();
    }
}


