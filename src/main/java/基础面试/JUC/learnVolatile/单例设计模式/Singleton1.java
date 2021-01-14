package 基础面试.JUC.learnVolatile.单例设计模式;

public class Singleton1 {

    private static Singleton1 instance;

    private Singleton1() {
    }
    // 方式1：懒汉式，多线程不安全
    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
