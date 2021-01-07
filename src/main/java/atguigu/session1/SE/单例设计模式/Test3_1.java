package atguigu.session1.SE.单例设计模式;

/**
 * @author ssl
 * @date 2020/4/8 14:07
 */
public class Test3_1 {
    public static void main(String[] args) {
        Singleton3_1 instance = Singleton3_1.getInstance();
        System.out.println("info：" + instance.getInfo());
        Singleton3_1 instance1 = Singleton3_1.getInstance();
        System.out.println("instance == instance1:" + (instance == instance1));
    }
}
