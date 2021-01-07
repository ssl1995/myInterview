package atguigu.session2.volatileDemo;

/**
 * 学习原子性：该线程中间不可被分割，但volatile不保证原子性，只能使用syn保证原子性
 */
public class VolatileDemo1 {
    public static void main(String[] args) {
        MyData myData = new MyData();
        // 1 20个线程，每个线程执行1000次
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    //保证原子性：使用原子包装类
                    myData.addAtomicPlus();
                }
            }, String.valueOf(i)).start();
        }

        //2 暂停一会儿线程，需要上面的线程计算完成
        while (Thread.activeCount() > 2) {
            //main线程等待
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int finally num = :" + myData.num);

        System.out.println(Thread.currentThread().getName() + "\t atomic finally num = :" + myData.num1);
    }
}
