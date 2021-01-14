package atguigu.session2.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProviderAndConsumerByBlockQueue {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        MyResources3 myShare = new MyResources3(blockingQueue);

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
            try {
                myShare.provider();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "生产者").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
            try {
                myShare.consumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "消费着").start();

        //暂停一会儿
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("5s到，全部活动结束");
        myShare.stop();
    }
}

