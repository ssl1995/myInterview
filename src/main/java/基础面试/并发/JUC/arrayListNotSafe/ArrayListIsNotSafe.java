package ssl.JUC.arrayListNotSafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListIsNotSafe {
    public static void main(String[] args) {
        ListIsNotSafe();
    }

    // 普通的集合类都是线程不安全的:java.util.ConcurrentModificationException
    private static void ListIsNotSafe() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list.toString());
            }, String.valueOf(i)).start();
        }
    }

    /*  集合安全：
        1.老API：Vector
        2.集合安全工具类：Collections.synchronizedList
        3.读写锁：new CopyOnWriteArrayList<>()
     */
    private static void ListSafe() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new Vector<>();
        List<String> list2 = Collections.synchronizedList(list);
        CopyOnWriteArrayList<String> list3 = new CopyOnWriteArrayList<>();
        list3.add("1");
        new HashSet<String>().add("1");
        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list.toString());
            }, String.valueOf(i)).start();
        }
    }
}
