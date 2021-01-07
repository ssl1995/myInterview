package atguigu.session2.threadPool;

import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 1 以下Executors创建线程池都不推荐使用
        // newFixedThreadPool：核心和最大线程数相同，等待队列是LinkedBlockingQueue，等待时间0
        ExecutorService fixedThread = Executors.newFixedThreadPool(5);
        // newCachedThreadPool：核心为0，等待队列是SynchronousQueue，最大线程数是最大整数，等待时间60s
        ExecutorService cachedThread = Executors.newCachedThreadPool();
        // newSingleThreadExecutor：核心和最大为0，等待队列是LinkedBlockingQueue，等待时间0
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
        // 1 推荐使用使用自建的线程池，学习7大参数
        ThreadPoolExecutor poolByMyself = new ThreadPoolExecutor(
                2, 5, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),//阻塞队类
                Executors.defaultThreadFactory(),//默认线程制造工程
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 1; i <= 20; i++) {
            int finalI = i;
            poolByMyself.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "\t 线程进入，\t 获得资源: " + finalI);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //终止线程池
        poolByMyself.shutdown();
        //while判断线程池是否终止
        while (!poolByMyself.isTerminated()) {

        }
        System.out.println("所有线程已经终止");
    }
}

