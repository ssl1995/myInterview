package atguigu.session2.volatileDemo;
/**
 * 高并发单例设计模式：
 */
public class SingletonDemo2 {
    // 1 如果没有volatile修饰，就会出现不安全啊问题
    // 原因在于某一个线程执行到第一次检测，读取到的instance不为null时，instance的引用对象可能没有完成初始化。
    private static volatile SingletonDemo2 instance;

    // 2 DCL:双端锁机制,synchronized锁的前后都进行判断，但是不是最安全的，因为编译器会指令重排
    public static  SingletonDemo2 getInstance() {
        if (instance == null) {
            synchronized (SingletonDemo2.class){
                if(instance==null){
                    instance = new SingletonDemo2();
                }
            }
        }
        return instance;
    }

    private SingletonDemo2() {
        System.out.println(Thread.currentThread().getName() + "：Singleton的构造器");
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            new Thread(() -> {
                SingletonDemo2 instance = SingletonDemo2.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
