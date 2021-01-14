package 基础面试.JUC.blockQueue;


import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronsBlockingQueue {
    public static void main(String[] args) {
        // SynchronousQueue:一个线程生产一个，等待别的线程消费完才能进行下去
        SynchronousQueue<Integer> blockingQueue = new SynchronousQueue();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + "，生产了1");
                blockingQueue.put(1);
                TimeUnit.SECONDS.sleep(1);
                //阻塞：SynchronousQueue使用put必须等待别的线程take后
                System.out.println(Thread.currentThread().getName() + "，生产了2");
                blockingQueue.put(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1").start();

        new Thread(() -> {
            try {
                //消费：：SynchronousQueue使用put必须等待别的线程take消费
                System.out.println(Thread.currentThread().getName() + "，消费了" + blockingQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "，消费了" + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2").start();
    }
}
