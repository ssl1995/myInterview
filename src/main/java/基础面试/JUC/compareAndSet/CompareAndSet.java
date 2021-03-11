package ssl.JUC.compareAndSet;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSet {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(2);
        atomicInteger.getAndIncrement();
    }
}
