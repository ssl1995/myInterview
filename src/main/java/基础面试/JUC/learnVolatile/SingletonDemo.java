package 基础面试.JUC.learnVolatile;


public class SingletonDemo {
    private static volatile SingletonDemo instance;

    private SingletonDemo() {
        System.out.println(Thread.currentThread().getName() + " 线程，创建实例了");
    }

    // 单线程下的单例设计模式是不安全的，会重复new 实例
    public static SingletonDemo getInstance() {
        if (instance == null) {
            instance = new SingletonDemo();
        }
        return instance;
    }

    // 共享变量未加volatile修饰的双端锁：由于指令重排序，还是有线程不安全的问题
    public static SingletonDemo getInstance1() {
        if (instance == null) {
            synchronized (SingletonDemo.class) {
                if (instance == null) {
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                SingletonDemo.getInstance1();
            }, String.valueOf(i)).start();
        }
    }
}
