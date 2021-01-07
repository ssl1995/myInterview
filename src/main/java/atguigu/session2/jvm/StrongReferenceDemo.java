package atguigu.session2.jvm;

/**
 * @author ssl
 * @date 2020/4/19 15:47
 */
public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2= o1;
        o1=null;
        System.gc();
        //o2依然存在=强引用不会被回收
        System.out.println(o2);
    }
}
