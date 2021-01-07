package atguigu.session2.volatileDemo;

/**
 * @author ssl
 * @date 2020/4/9 16:21
 * 高并发的单例设计模式：
 * 1  synchronized getInstance() ，但是太影响性能
 */
public class SingletonDemo1 {

    private static  SingletonDemo1 instance;
    //synchronized getInstance() ，但是太影响性能
    public static synchronized SingletonDemo1 getInstance() {
        if (instance == null) {
            instance = new SingletonDemo1();
        }

        return instance;
    }

    private SingletonDemo1() {
        System.out.println(Thread.currentThread().getName() + "：Singleton的构造器");
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo1 instance = SingletonDemo1.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
