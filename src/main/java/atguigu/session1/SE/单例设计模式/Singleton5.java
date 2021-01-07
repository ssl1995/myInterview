package atguigu.session1.SE.单例设计模式;

/**
 * 饿汉式2：线程安全
 */
public class Singleton5 {
    private static Singleton5 instance;

    static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        //线程阻塞就会产生不安全问题
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }

    private Singleton5() {
    }
}
