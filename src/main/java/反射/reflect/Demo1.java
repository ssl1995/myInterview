package 反射.reflect;
import org.junit.Test;
import 反射.bean.User;

import java.lang.reflect.Constructor;

public class Demo1 {

    /**
     * 三种获取字节码的方法
     */
    @Test
    public void test1() throws Exception {
        // 类.class
        Class<String> stringClass = String.class;
        // Class。forName(className)
        Class<?> userClazz = Class.forName("bean.User");
        User user = new User();
        // 对象.getClass()
        Class<? extends User> userClazz1 = user.getClass();
    }

    /**
     * 获取非私有构造器
     */
    @Test
    public void test2() throws Exception {
        Class<?> userClazz = Class.forName("bean.User");
        Constructor<?> c1 = userClazz.getConstructor();
        Constructor<?> c2 = userClazz.getConstructor(int.class);
        Constructor<?> c3 = userClazz.getConstructor(int.class, String.class);
        User user = (User) c3.newInstance(1, "A");
        System.out.println(user);
    }

    /**
     * 获取私有构造器
     */
    @Test
    public void test3() throws Exception {
        Class<?> userClazz = Class.forName("bean.User");
        // 私有需要declared修饰
        Constructor<?> c = userClazz.getDeclaredConstructor(String.class);
        // setAccessible设置暴露破解
        c.setAccessible(true);
        User user = (User) c.newInstance("A");
        System.out.println(user);
    }

    /**
     * 获取所有构造器：私有和非私有
     */
    @Test
    public void test4() throws Exception {
        Class<?> userClazz = Class.forName("bean.User");
        Constructor<?>[] constructors = userClazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }
    }
}
