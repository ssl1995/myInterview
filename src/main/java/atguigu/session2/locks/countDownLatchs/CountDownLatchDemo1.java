package atguigu.session2.locks.countDownLatchs;

import java.util.concurrent.CountDownLatch;

//使用枚举类命名：避免使用if-else if
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国，被灭了");
                //倒计时级数下降
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }
        //main线程等待上面结束，才启动
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "：秦国一统天下");
    }
}
