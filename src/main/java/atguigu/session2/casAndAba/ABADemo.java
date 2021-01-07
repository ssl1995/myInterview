package atguigu.session2.casAndAba;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
public class ABADemo {

    //普通原子引用
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        //使用过AtomicReference演示ABA问题

        new Thread(() -> {
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
        }, "t1").start();

        new Thread(() -> {
            //休眠，是的t1线程先执行完成BA操作
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean result1 = atomicReference.compareAndSet(100, 101);
            //结果虽然是101，但是中间的100被替换了2次，100到101再到100,这是不友好的
            System.out.println(Thread.currentThread().getName() + "执行结果:" + result1 + "\t" + atomicReference.get());

        }, "t2").start();

    }

}
