package atguigu.session1.Spring.JDK动态代理;


public class DynamicProxy {
    public static void main(String[] args) {
        // 1 被代理对象：真实角色
        PeopleInterface peopleI = new People();
        // 2 自定义处理器：代理角色
        // 代理角色实现真实角色的抽象接口
        MyHandle myHandle = new MyHandle(peopleI);
        // 3 代理角色获得代理类
        PeopleInterface people = (PeopleInterface) myHandle.getProxy();
        // 4 由proxy动态代理调用被代理的接口方法
        people.fun();

    }
}
