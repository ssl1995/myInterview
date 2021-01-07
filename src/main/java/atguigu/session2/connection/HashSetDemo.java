package atguigu.session2.connection;

import java.util.HashSet;

/**
    HashSet底层是HashMap，add方法中key = 传入的值，而value=set集合预定义的PRESENT常量
 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> map = new HashSet<>();
        map.add("a");
        boolean result = map.contains("a");
        System.out.println(result);
    }
}
