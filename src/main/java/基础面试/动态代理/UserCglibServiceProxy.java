package ssl.动态代理;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class UserCglibServiceProxy implements MethodInterceptor {
    // 1.设置被代理对象
    private Object target;

    public UserCglibServiceProxy(Object target) {
        this.target = target;
    }

    // 2.创建被代理对象
    public Object getProxyInstance() {
        // 工具类
        Enhancer en = new Enhancer();
        // 设置被代理作为父类
        en.setSuperclass(target.getClass());
        // 将本类设置为回调函数
        en.setCallback(this);
        // 返回被代理对象
        return en.create();
    }

    // 3.重写intercept方法，用法和JDK动态代理一样
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强方法1：cglib动态代理开始");
        Object invoke = method.invoke(target, args);
        System.out.println("增强方法2：cglib动态代理结束");
        return invoke;
    }
    // 4.测试线程
    public static void main(String[] args) {
        UserCglibServiceImpl target1 = new UserCglibServiceImpl();
        UserCglibServiceImpl target2 =(UserCglibServiceImpl) new UserCglibServiceProxy(target1).getProxyInstance();
        target2.hobby();
    }
}
