package atguigu.session2.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void main(String[] args) {
        // 创建线程池方式1：Executors，里面封装了很多，但都不推荐使用
        // newFixedThreadPool：核心和最大线程数相同，等待队列是LinkedBlockingQueue，等待时间0
        ExecutorService fixedThread = Executors.newFixedThreadPool(5);
        // newCachedThreadPool：核心为0，等待队列是SynchronousQueue，最大线程数是最大整数，等待时间60s
        ExecutorService cachedThread = Executors.newCachedThreadPool();
        // newSingleThreadExecutor：核心和最大为0，等待队列是LinkedBlockingQueue，等待时间0
        ExecutorService singleThread = Executors.newSingleThreadExecutor();
    }
}
