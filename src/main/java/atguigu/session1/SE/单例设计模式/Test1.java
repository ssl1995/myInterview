package atguigu.session1.SE.单例设计模式;

/**
 * @author ssl
 * @date 2020/4/8 14:19
 */
public class Test1 {
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1==instance2);
    }
}
