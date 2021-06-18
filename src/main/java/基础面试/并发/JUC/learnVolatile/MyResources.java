package ssl.JUC.learnVolatile;

import java.util.concurrent.atomic.AtomicInteger;

public class MyResources {
    volatile int data = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    void add() {
        this.data = 1;
    }

    void add1() {
        this.data++;
    }

    void addByAtomic() {
        this.atomicInteger.getAndIncrement();
    }


}
