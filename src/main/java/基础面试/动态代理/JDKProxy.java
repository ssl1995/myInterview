package ssl.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    // 代理类继承InvocationHandler，重写invoke方法
    // 1.获取被代理对象
    private Object target;

    public JDKProxy(Object target) {
        this.target = target;
    }

    // 2.代理类获取被代理角色
    private Object getProxyInstance() {

        // 返回给代理类和被代理增强的接口，并生成被代理对象实例
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),// 第二个参数说明JDK动态代理只针对接口增强
                this);
    }

    // 3.代理类重写invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 增强方法1
        System.out.println("增强方法1：JDK动态代理开始");
        // 被代理对象接口实现的的返回值 = 固定写法
        Object result = method.invoke(target, args);
        // 增强方法2
        System.out.println("增强方法2：JDK动态代理结束");
        return result;
    }


    // 4.测试线程
    public static void main(String[] args) {
        UserManagerImpl userManager = new UserManagerImpl();
        JDKProxy jdkProxy = new JDKProxy(userManager);
        UserManager user = (UserManager) jdkProxy.getProxyInstance();
        user.addUser("张三", "123");
    }
}
