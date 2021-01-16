package 基础面试.JUC.threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1 推荐使用使用自建的线程池，学习7大参数
        ThreadPoolExecutor myThreadPool = new ThreadPoolExecutor(
                2, 5, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                // AbortPolicy:直接抛出异常
                // CallerRunsPolicy:用调用者所在的线程（本类中的main）来执行任务
                // DiscardPolicy:丢弃进来的任务
                // DiscardOldestPolicy:丢弃之前的第一个任务
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1; i <= 20; i++) {
            int resource = i;
            // 2.执行线程池中的线程
            myThreadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 线程进入，\t 获得资源: " + resource);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 3.终止线程池
        myThreadPool.shutdown();
        // 4.while判断线程池是否终止
        while (!myThreadPool.isTerminated()) {

        }
        System.out.println("所有线程已经终止");
    }
}

