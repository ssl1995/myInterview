package atguigu.session1.JVM;

import java.io.FileInputStream;
import java.lang.reflect.Method;

public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
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

        /**
         * 自定义加载器，自定加载路径，就是重写findClass()
         */
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

        /**
         * 打破双亲委派机制，重写loadClass()
         */
        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t0 = System.nanoTime();
                    long t1 = System.nanoTime();
                    // 指定包下的类打包双亲委派，否则使用双亲委派
                    if (!name.startsWith("Q1/JVM")) {
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

        public static void main(String[] args) throws Exception {
            MyClassLoader classLoader = new MyClassLoader("E:/test");
            Class<?> aClass = classLoader.loadClass("Q1.JVM.User1");
            Object object = aClass.newInstance();
            Method method = aClass.getDeclaredMethod("sout", null);
            method.invoke(object, null);
            System.out.println(aClass.getClassLoader().getClass().getName());
        }
        /*运行结果：
            自己的加载器加载调用方法
            Q1.JVM.MyClassLoaderTest$MyClassLoader
         */
    }
}
