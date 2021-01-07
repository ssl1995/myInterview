package atguigu.session1.SE.单例设计模式;
/*
    懒汉式最终版：延迟创建实例，不能加final修饰
 */
public class Singleton7 {
    //使用 最终版的volatile防止指令重排
    private static volatile Singleton7 INSTANCE;

    private Singleton7() {
    }

    //线程安全的效率高的懒汉式
    public static Singleton7 getInstance() {
        if (INSTANCE == null) {
            //并发状态下，需要加双端锁DCL : 双端检锁机制
            //缺点: 由于有编译器和JVM的指令重排，所以这种情况不是100%正确
            /*
                原因：当一条线程访问instance不等于null时候，由于instance实例由于指令重排未能初始化成功，造成了线程安全问题
             */
            synchronized (Singleton7.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton7();
                }
            }

        }
        return INSTANCE;
    }
}
