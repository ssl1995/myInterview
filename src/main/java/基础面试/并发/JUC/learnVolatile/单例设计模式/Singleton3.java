package ssl.JUC.learnVolatile.单例设计模式;

public class Singleton3 {

    private static Singleton3 instance = new Singleton3();

    private Singleton3() {
    }

    // 方式2：饿汉式，线程安全是因为synchronized，单例是因为classloader机制避免了多线程的同步问题
    public static synchronized Singleton3 getInstance() {
        return instance;
    }
}
