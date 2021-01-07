package atguigu.session1.SE.单例设计模式;

/**
    懒汉式1：线程不安全下的单例
 */
public class Singleton4 {
    private static Singleton4 instance;

    static Singleton4 getInstance() {
        if (instance == null) {
            try {
                //线程阻塞就会产生不安全问题
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }

    private Singleton4() {
    }

}
