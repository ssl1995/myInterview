package ssl.JUC.learnVolatile.单例设计模式;

public class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHandle {
        private static final Singleton5 INSTANCE = new Singleton5();
    }

    // 方式5：静态内部类，比方式4更合理，延迟是因为内部类被装载了，才会使用；线程安全是因为类加载机制保障了线程安全
    public static Singleton5 getInstance() {
        return SingletonHandle.INSTANCE;
    }
}
