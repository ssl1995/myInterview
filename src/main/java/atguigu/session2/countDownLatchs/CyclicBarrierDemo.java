package atguigu.session2.countDownLatchs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        // int parties 屏障前等待线程数量
        CyclicBarrier barrier1 = new CyclicBarrier(1);
        // int parties 屏障前等待线程数量, Runnable barrierAction 到达屏障后执行的语句
        CyclicBarrier barrier = new CyclicBarrier(7, () -> {
            System.out.println("龙珠齐，召唤神龙");
        });
        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 收集到第" + temp + "颗龙珠");
                try {
                    //满足屏障初始化条件才能执行，否则等待
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
