package atguigu.session1.JVM;

public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESCipher.class.getClassLoader());
        System.out.println(TestJDKClassLoader.class.getClassLoader());
        System.out.println("--------");
        /* 运行结果：
            null
            sun.misc.Launcher$ExtClassLoader@5e2de80c
            sun.misc.Launcher$AppClassLoader@18b4aac2
         */
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
    }
}
