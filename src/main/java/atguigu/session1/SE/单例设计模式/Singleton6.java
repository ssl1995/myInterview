package atguigu.session1.SE.单例设计模式;

/*
    懒汉式3：静态内部类创建单例
    使用场景：单线程下
 */
public class Singleton6 {

    //静态内部类创建懒汉式
    private static class innerGetInstance {
        private static final Singleton6 instance = new Singleton6();
    }
    //调用方法创建静态内部类
    private static Singleton6 getInstance() {
        return innerGetInstance.instance;
    }
    //构造器私有化
    private Singleton6() {
        System.out.println("Singleton6构造器");
    }

}
