package atguigu.session2.casAndAba;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class CASDemo {
    public static void main(String[] args) {
        //1 点开学习getAndIncrement源码：do-while
        AtomicInteger atomicInteger = new AtomicInteger(5);
        // 也可操作数组
        int[] arr = {1, 2};
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(arr);
        //2 交换成功：变成2019
        boolean result1 = atomicInteger.compareAndSet(5, 2019);
        //3 交换失败：还是2019
        boolean result2 = atomicInteger.compareAndSet(5, 2020);
        System.out.println("result1：" + result1 +"\t atomicInteger:"+atomicInteger.get());
        System.out.println("result2：" + result2 +"\t atomicInteger:"+atomicInteger.get());
        //4 学习观看CAS源码
        int increment = atomicInteger.getAndIncrement();


    }
}
