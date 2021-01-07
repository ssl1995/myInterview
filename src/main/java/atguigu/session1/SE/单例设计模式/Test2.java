package atguigu.session1.SE.单例设计模式;

/**
 * @author ssl
 * @date 2020/4/8 14:20
 */
public class Test2 {
    public static void main(String[] args) {
        Singleton2 instance1 = Singleton2.instance;
        Singleton2 instance2 = Singleton2.instance;
        System.out.println(instance1==instance2);

    }
}
