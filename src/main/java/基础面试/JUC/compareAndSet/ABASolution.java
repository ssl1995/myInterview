package 基础面试.JUC.compareAndSet;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABASolution {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> stampedReference = new AtomicStampedReference<>(100, 1);
        new Thread(() -> {
            int stamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 版本号1:" + stamp);
            //暂停1s等t2线程
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + " 版本号2:" + stampedReference.getStamp());
            stampedReference.compareAndSet(101, 100, stampedReference.getStamp(), stampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName() + " 版本号3:" + stampedReference.getStamp());
            System.out.println(Thread.currentThread().getName() + " 当前实际值:" + stampedReference.getReference());
        }, "t1").start();

        new Thread(() -> {
            int exceptStamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 期望版本号:" + exceptStamp);
            //暂停3s等t1线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // t1 线程执行完毕后，版本号 = 3 与 这里的 exceptStamp永不相同，所以执行会失败
            boolean result = stampedReference.compareAndSet(100, 200, exceptStamp, exceptStamp + 1);
            int nowStamp = stampedReference.getStamp();
            System.out.println(Thread.currentThread().getName() + " 修改值结果:" + result + " 当前版本号：" + nowStamp + " 期望版本号:" + exceptStamp);
            System.out.println(Thread.currentThread().getName() + " 当前实际值:" + stampedReference.getReference());
        }, "t2").start();
    }

}
