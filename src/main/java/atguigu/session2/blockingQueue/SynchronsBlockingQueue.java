package atguigu.session2.blockingQueue;


import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronsBlockingQueue {
    public static void main(String[] args) {
        SynchronousQueue<Integer> blockingQueue = new SynchronousQueue();

        new Thread(() -> {
            try {
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName() + "生产了1");
                TimeUnit.SECONDS.sleep(1);
                //阻塞：SynchronousQueue使用put必须等待别的线程take后
                blockingQueue.put(2);
                System.out.println(Thread.currentThread().getName() + "生产了2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                //消费：：SynchronousQueue使用put必须等待别的线程take消费
                System.out.println(Thread.currentThread().getName() + "消费了"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName() + "消费了"+   blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}
