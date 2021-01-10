package atguigu.session2.volatileDemo;

public class Singleton4 {
    // volatile防止代码指令重排
    private volatile static Singleton4 instance;

    private Singleton4() {
    }

    // 方式4：双端锁+volatile
    public static Singleton4 getInstance() {
        // 双端锁提高效率
        if (instance == null) {
            synchronized (Singleton4.class) {
                if (instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
