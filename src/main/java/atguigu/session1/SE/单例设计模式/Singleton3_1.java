package atguigu.session1.SE.单例设计模式;

import java.io.IOException;
import java.util.Properties;

/**
 * 饿汉式3：静态代码块什么时候使用？加载资源文件
 */
public class Singleton3_1 {

    private static Singleton3_1 instance = null;
    //加载某个资源文件
    private String info;

    //利用内部类加载某个资源文件
    static {
        Properties properties = new Properties();
        try {
            properties.load(Singleton3_1.class.getClassLoader().getResourceAsStream("Q1/SE/单例设计模式/info.properties"));
            String infoStr = properties.getProperty("info");
            instance = new Singleton3_1(infoStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //构造器私有化
    private Singleton3_1(String info) {
        this.info = info;
    }

    public static Singleton3_1 getInstance() {
        return instance;
    }

    public static void setInstance(Singleton3_1 instance) {
        Singleton3_1.instance = instance;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
