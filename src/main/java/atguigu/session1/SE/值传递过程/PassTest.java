package atguigu.session1.SE.值传递过程;

import java.util.*;

public class PassTest {
    public static void main(String[] args) {

        int i = 1;
        String str = "hello";
        Integer num = 200;
        int[] arr = {1, 2, 3, 4, 5};
        MyData my = new MyData();
        change(i, str, num, arr, my);
        /*
        结果：传值还是传引用？
            i = 1 传值。基本数据类型不会变
            str = hello 传常量池地址。字符串不变
            num = 200，传堆中的地址。原包装类不变，和字符串一样
            arr = [2, 2, 3, 4, 5] 传堆中数组的首地址。发生了改变
            my.a = 11，传堆中地址，资源类变量发生改变。资源类中的变量，会在堆中生成一个实例
         */
        System.out.println("i = " + i);
        System.out.println("str = " + str);
        System.out.println("num = " + num);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("my.a = " + my.a);
    }

    public static void change(int j, String s, Integer num, int[] arr, MyData myData) {
        j += 1;
        s += "world";
        num += 1;
        arr[0] += 1;
        myData.a += 1;
    }
}

class MyData {
    int a = 10;
}

