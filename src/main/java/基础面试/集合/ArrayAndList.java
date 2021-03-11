package ssl.集合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAndList {
    public static void main(String[] args) {
        // 1.数组遍历:Arrays.toString
        int[] arr = {1, 2, 3};
        System.out.println(Arrays.toString(arr));
        // 2.数组转成list，泛型说明不推荐使用，多此一举
        List<int[]> ints1 = Arrays.asList(arr);
        List<int[]> ints = Collections.singletonList(arr);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
        System.out.println("------------");
        // 3.list遍历：直接遍历即可
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
        // 4.list转换成数组，list名.toArray(指定数组类型和长度)
        Integer[] integers = arrayList.toArray(new Integer[3]);
        System.out.println(Arrays.toString(integers));
    }
}
