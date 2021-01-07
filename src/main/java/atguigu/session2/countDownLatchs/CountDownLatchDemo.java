package atguigu.session2.countDownLatchs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        // 倒计时锁，初始化长度容量为6
        CountDownLatch countDownLatch = new CountDownLatch(6);
        // 创建6个线程
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 走了");
                //倒计时级数下降
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // main线程执行到，等待上面的线程执行完
        countDownLatch.await();
        // 最后main关门
        System.out.println(Thread.currentThread().getName() + "\t 关门");
    }
}
