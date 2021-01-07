package atguigu.session1.JVM;


public class EscTest {
    public User test1() {
        User user = new User();
        user.setId(1);
        user.setUserName("张三");
        return user;
    }

    public void test2() {
        User user = new User();
        user.setId(2);
        user.setUserName("李四");
    }
}
