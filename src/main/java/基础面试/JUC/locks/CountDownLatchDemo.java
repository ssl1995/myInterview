package 基础面试.JUC.locks;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭了");
                countDownLatch.countDown();
                // 使用枚举类给线程命名，学习countDownLatch和枚举类减少if判断作用
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "：秦国一统天下");
    }
}
