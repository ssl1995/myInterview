package 基础面试.JVM;
import com.sun.crypto.provider.DESCipher;

public class ClassLoaderDemo {
    public static void main(String[] args) {
        ClassLoader bootstrapCL = String.class.getClassLoader();
        System.out.println("启动类加载器：" + bootstrapCL);
        ClassLoader extCL = DESCipher.class.getClassLoader();
        System.out.println("扩展类加载器：" + extCL);
        ClassLoader appCL = ClassLoaderDemo.class.getClassLoader();
        System.out.println("应用类加载器：" + appCL);
    }
}
