package atguigu.session2.casAndAba;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ABADemo {
    // AtomicInteger底层使用CAS比较并交换，但是会出现ABA问题
    static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> {
            atomicInteger.compareAndSet(1, 2);
            atomicInteger.compareAndSet(2, 1);
        }, "t1").start();

        new Thread(() -> {
            //休眠，是的t1线程先执行完成BA操作
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean res = atomicInteger.compareAndSet(1, 3);
            System.out.println(Thread.currentThread().getName() + "执行结果:" + res + "\t" + atomicInteger.get());

        }, "t2").start();

    }

}
