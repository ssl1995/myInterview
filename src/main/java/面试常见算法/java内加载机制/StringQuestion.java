package 面试常见算法.java内加载机制;

public class StringQuestion {
    /*
    intern:返回值一个字符串，内容与此字符串相同，但一定取自具有唯一字符串的池
     */
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("同城").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());
        System.out.println("-----------");
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }
}
