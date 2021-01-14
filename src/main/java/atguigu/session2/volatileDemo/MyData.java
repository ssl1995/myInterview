package atguigu.session2.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

public class MyData {
    //volatile保证可见性，防止指令重排，不保证原子性
    int num = 0;
    // 保证原子性1：使用原子类型
    // 保证原子性2：方法使用syn修饰，缺点就是没必要，杀鸡用牛刀
    AtomicInteger num1 = new AtomicInteger();

    public void addTo() {
        this.num = 60;
    }

    public void addPlusPlus() {
        this.num++;
    }

    public void addAtomicPlus() {
        //补充：CAS是什么？
        num1.getAndIncrement();
    }
}
