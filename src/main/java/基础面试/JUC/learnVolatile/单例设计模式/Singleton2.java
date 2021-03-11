package ssl.JUC.learnVolatile.单例设计模式;

public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }
    // 方式2：懒汉式，线程安全，加了synchronized修饰方法
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
