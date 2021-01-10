package atguigu.session2.volatileDemo;

public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {
    }
    // 方式1：懒汉式，线程不安全
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
