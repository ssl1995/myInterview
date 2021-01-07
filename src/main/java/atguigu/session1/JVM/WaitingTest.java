package atguigu.session1.JVM;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WaitingTest {
    Object instance = null;

    public static void main(String[] args) {
        WaitingTest t1 = new WaitingTest();
        WaitingTest t2 = new WaitingTest();
        t1.instance = t2;
        t2.instance = t1;
        t1 = null;
        t2 = null;
        SoftReference<User> softReference = new SoftReference<User>(new User());
        WeakReference<User> weakReference = new WeakReference<>(new User());
    }
}
