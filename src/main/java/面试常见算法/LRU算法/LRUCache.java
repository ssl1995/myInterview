package 面试常见算法.LRU算法;

import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
    // 双端链表便于删除头部
    private LinkedList<Node> cache;
    private int capacity;

    // 构造器指定默认缓存大小
    public LRUCache(int capacity) {
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    // 插入操作
    private void add(String key, String value) {
        Iterator<Node> iterator = cache.iterator();
        // 1.先遍历删除存在相同的元素
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                iterator.remove();
                break;
            }
        }
        // 2.判断缓存是否满
        if (capacity == cache.size()) {
            cache.removeFirst();
        }
        // 3.新数据添加的尾部
        cache.add(new Node(key, value));
    }

    // 取出操作
    public String remove(String key) {
        Iterator<Node> iterator = cache.descendingIterator();
        String value = "";
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key.equals(key)) {
                value = node.value;
                // LRU：取出的元素放到尾部，让头部是最不常用的元素
                // 把原来该位置的元素删除，并把新元素添加到链表尾部
                iterator.remove();
                add(key, value);
                break;
            }
        }
        return value;
    }
}
