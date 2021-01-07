package atguigu.session1.Spring.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandle implements InvocationHandler {
    // 被代理对象实例
    private Object object;

    // 构造器
    public MyHandle(Object object) {
        this.object = object;
    }

    // 可以封装获取动态代理的
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                object.getClass().getInterfaces(), this);
    }

    // 实现抽象接口的实体方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(this.object, args);
        after();
        return result;

    }

    // 增强的方法
    private void before() {
        System.out.println("增强的before方法");
    }
    private void after() {
        System.out.println("增强的after方法");
    }
}
