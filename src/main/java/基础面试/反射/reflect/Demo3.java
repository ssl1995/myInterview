package ssl.反射.reflect;


import org.junit.Test;
import ssl.反射.bean.User;

import java.lang.reflect.Field;
import java.util.Date;


public class Demo3 {
    private final String userPath = "基础面试.反射.bean.User";
    /**
     * 获取非静态的私有成员变量
     */
    @Test
    public void test1() throws Exception {
        Class<?> userClass = Class.forName(userPath);
        User user = (User) userClass.newInstance();
        Field id = userClass.getDeclaredField("id");
        id.setAccessible(true);
        id.set(user, 2);
        Field name = userClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(user, "李四");
        System.out.println(user);
    }

    /**
     * 获取静态成员变量
     */
    @Test
    public void test2() throws Exception {
        Class<?> userClass = Class.forName(userPath);
        Field date = userClass.getDeclaredField("date");
        date.setAccessible(true);
        date.set(null, new Date());
        System.out.println("User的Date:" + User.getDate());
    }
}
