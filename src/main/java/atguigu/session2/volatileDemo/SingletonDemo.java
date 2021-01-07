package atguigu.session2.volatileDemo;

/**
 * @author ssl
 * @date 2020/4/9 16:21
 * 单线程单例设计模式带来的弊端：无法准确保证实例
 *
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance;

    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + "：Singleton的构造器");
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo instance = SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
