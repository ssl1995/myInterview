package 基础面试.集合;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapQ {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        hashmap.put(null, null);// hashmap两个都可以存null
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(null, null);//hashtable任一个都不能存null，但idea不会报错，运行会出现空指针异常
    }
}
