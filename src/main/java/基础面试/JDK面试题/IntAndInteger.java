package 基础面试.JDK面试题;

public class IntAndInteger {
    public static void main(String[] args) {
        // 问题1：Integer和int比较
        Integer a = new Integer(3);
        Integer b = 3;
        System.out.println(a == b);// false，引用类型和值类型不能比较
        Integer d = new Integer(3);
        System.out.println(a == d); // false，两个引用类型用==不能比较
        int c = 3;
        System.out.println(c == d); // true，Integer遇到int比较，Integer会拆箱成int做值比较
        System.out.println("-------");

        // 问题2:Integer值返回缓存
        Integer f1 = 100;
        Integer f2 = 100;
        System.out.println(f1 == f2);// true
        Integer f3 = 129;
        Integer f4 = 129;
        System.out.println(f3 == f4);
        System.out.println("-------");// false

    }

}
