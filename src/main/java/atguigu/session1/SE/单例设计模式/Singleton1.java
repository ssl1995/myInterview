package atguigu.session1.SE.单例设计模式;

class Singleton1 {
    //直接创建该实例对象
    private static final Singleton1 instance = new Singleton1();
    //构造器私有化
    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
