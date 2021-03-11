package ssl.集合;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUTest {
    // 0.指定map长度size=5
    private static final int size = 5;

    public static void main(String[] args) {
        // 1. LinkedHashMap三大参数，重写removeEldestEntry
        Map<String, String> map = new LinkedHashMap<String, String>(size, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {

                return size() > size;
            }
        };
        // 2.添加5个数，使得map满
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        System.out.println("map:" + map.toString());
        // 3.指定map满了，再put就会移除表头第一个元素:1=1
        map.put("6", "6");
        System.out.println("map:" + map.toString());
        // 4.get取出的元素，表示是常用的，放回到表尾
        map.get("3");
        System.out.println("map:" + map.toString());
    }
}
