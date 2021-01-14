package 基础面试.JUC.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        // 抛出异常组：add/remove/element：会抛出异常:IllegalStateException,一言不合就报异常不推荐使用
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");
        // blockingQueue.add("4"); 直接抛出异常
        blockingQueue.remove("1");
        blockingQueue.remove("2");
        blockingQueue.remove("3");
        System.out.println("--抛出异常组--");

        // 返回布尔型组：offer/poll/peek:失败返回布尔型
        blockingQueue.offer("11");
        blockingQueue.offer("12");
        blockingQueue.offer("13");
        System.out.println(blockingQueue.offer("14"));
        blockingQueue.poll();
        blockingQueue.poll();
        blockingQueue.poll();
        System.out.println("--返回布尔组--");

        // 等待组：put/take:满了就一直等待，等待是为了只要有数据出去立马添加
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
//        blockingQueue.put("d"); 这样会一直等待
//        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println("--等待组--");

        // 设置时间组：offer/poll设置失败等待时间
        System.out.println(blockingQueue.offer("a", 1L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 1L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 1L, TimeUnit.SECONDS));
        System.out.println("--设置时间组--");
    }
}
