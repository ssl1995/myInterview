package ssl.JUC.threadPool;


import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class WriterThreadPoolDemo {
    public static void main(String[] args) {
        ThreadPoolExecutor thread = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
        //手写线程池时候，最大线程数=max+queue,如果超过就看Policy的策略选择
        /*
            AbortPolicy()：直接抛出异常。CallerRunsPolicy：超过就回归到调用者线程。
            DiscardOldestPolicy:超过时候，放弃最长时间线程
            DiscardPolicy：超过最大线程数直接丢弃


         */
        for (int i = 1; i <= 9; i++) {
            thread.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 开始执行");
            });
        }
        thread.shutdown();

    }

    @Test
    public void Setmax() {
        //手写线程池时候，选择Maximum
        //CPU密集型:=核数+1，保持CPU的高速全力运行
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
