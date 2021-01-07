package atguigu.session1.SE.单例设计模式;

/*
    饿汉式3：利用静态代码块(其实和饿汉式1是一样的)
 */
public class Singleton3 {
    private static final Singleton3 instance;

    static {
        instance = new Singleton3();
    }

    //构造器私有化
    private Singleton3() {
    }
}
