package atguigu.session1.Spring.JDK动态代理;

public class People implements PeopleInterface{
    @Override
    public void fun() {
        System.out.println("这是People的fun方法");
    }
}
