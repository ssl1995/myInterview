package ssl.JUC.compareAndSet;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ABAQuestion {
    public static void main(String[] args) {
        AtomicReference<Integer> reference = new AtomicReference<>(1);

        new Thread(() -> {
            reference.compareAndSet(1, 2);
            reference.compareAndSet(2, 1);
        }, "线程1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reference.compareAndSet(1, 1000);
            System.out.println(Thread.currentThread().getName() + ",update:" + reference.get());
        }, "线程2").start();
    }
}
