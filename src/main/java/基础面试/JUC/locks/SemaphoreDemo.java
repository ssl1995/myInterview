package 基础面试.JUC.locks;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟3个车位，同时只能有3个线程同时访问，形参=1就是syn
        // 1.同步器semaphore（信号量）：指定X个线程可以获取资源
        Semaphore semaphore = new Semaphore(3);
        // 2.创建4个线程=有4个车位
        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                try {
                    // 3.信号量开始计算
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "\t 停1s后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 4.信号量释放计数
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
