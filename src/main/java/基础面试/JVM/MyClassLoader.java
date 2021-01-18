package 基础面试.JVM;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class MyClassLoader {
    static class MyStaticCL extends ClassLoader {
        private String classPath;

        public MyStaticCL(String classPath) {
            this.classPath = classPath.replaceAll("\\.", "/");
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        // 自定义类加载器：重写findClass
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                // 转换成class对象返回
                return defineClass(name, data, 0, data.length);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        // 打破双亲委派：重写loadClass
        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    long t1 = System.nanoTime();
                    // ，否则使用双亲委派
                    if (!name.startsWith("基础面试.JVM")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        c = findClass(name);
                    }
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String classpath = "E:\\product\\test";
        // 指定类加载器：E:\product\test\基础面试\JVM下的user.class
        String userClass = "基础面试.JVM.User";
        MyStaticCL classLoader = new MyStaticCL(classpath);
        Class<?> userClass1 = classLoader.loadClass(userClass);
        Object object = userClass1.newInstance();
        Method method = userClass1.getDeclaredMethod("print", null);
        method.invoke(object, null);
        System.out.println("自定义加载器名字:" + userClass1.getClassLoader().getClass().getName());
    }
}
