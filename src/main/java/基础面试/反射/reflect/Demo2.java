package ssl.反射.reflect;


import org.junit.Test;
import ssl.反射.bean.User;

import java.lang.reflect.Method;
import java.util.Date;

public class Demo2 {

    private final String userPath = "基础面试.反射.bean.User";

    /**
     * 获取非私有的成员方法
     */
    @Test
    public void test1() throws Exception {
        Class<?> claszz = Class.forName(userPath);
        User user = (User) claszz.newInstance();
        Method fun1 = claszz.getMethod("fun1", null);
        fun1.invoke(user, null);
        Method fun2 = claszz.getMethod("fun2", int.class);
        fun2.invoke(user, 1);
        Method fun3 = claszz.getMethod("fun3", int.class, String.class);
        fun3.invoke(user, 1, "A");
    }

    /**
     * 获得私有方法
     */
    @Test
    public void test2() throws Exception {
        Class<?> claszz = Class.forName(userPath);
        User user = (User) claszz.newInstance();
        // declared修饰private
        Method fun4 = claszz.getDeclaredMethod("fun4", Date.class);
        // setAccessible设置暴露破解
        fun4.setAccessible(true);
        fun4.invoke(user, new Date());
    }

    /**
     * 获得无数组参数的静态方法
     */
    @Test
    public void test3() throws Exception {
        Class<?> claszz = Class.forName(userPath);
        Method fun5 = claszz.getDeclaredMethod("fun5");
        fun5.invoke(null);
    }

    /**
     * 获得String数组参数的静态方法
     */
    @Test
    public void test4() throws Exception {
        Class<?> claszz = Class.forName(userPath);
        Method fun6 = claszz.getDeclaredMethod("fun6", String[].class);
        // fun6.invoke(null, new String[]{"1","2"}); 是要报错的
        // 以下两种方式解决
        fun6.invoke(null, (Object) new String[]{"1", "2"});
        fun6.invoke(null, new Object[]{new String[]{"1", "2"}});
    }
}