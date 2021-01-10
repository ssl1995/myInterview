package atguigu.session2.volatileDemo;

public class Singleton5 {
    private Singleton5() {
    }
    private static class SingletonHandle {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    // 方式5：静态内部类，比方式4更合理，因为内部类被装载了，才会使用；并且类加载机制保障了线程安全
    public static Singleton5 getInstance() {
        return SingletonHandle.INSTANCE;
    }
}
