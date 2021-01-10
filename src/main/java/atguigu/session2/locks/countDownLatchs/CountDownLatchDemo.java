package atguigu.session2.locks.countDownLatchs;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws Exception {
        // 1.同步器countDownLatch：让某个线程等待其他指定个数的线程执行完再执行
        CountDownLatch countDownLatch = new CountDownLatch(5);
        // 2.创建5个线程
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 走了");
                //倒计时级数下降
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        // 3.同步器countDownLatch让上面5个线程执行完就关闭
        countDownLatch.await();
        // 4.最后main线程等待上面指定5个线程执行，再执行
        System.out.println(Thread.currentThread().getName() + "\t 关门");

    }
}
