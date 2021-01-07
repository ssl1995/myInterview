package atguigu.session2.countDownLatchs;


import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    public static void main(String[] args) {
        // 模拟3个车位，同时只能有3个线程同时访问，形参=1就是syn
        Semaphore semaphore = new Semaphore(3);
        // 4个线程=有4个车位
        for (int i = 1; i <= 4; i++) {
            new Thread(() -> {
                try {
                    //获取计数
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t 抢到车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName() + "\t 停1s后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放计数
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
