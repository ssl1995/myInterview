package 基础面试.Float;

public class Demo {
    public static void main(String[] args) {
        float f1 = 423432423f;
        System.out.println("f1:" + f1);// f1:4.23432416E8
        float f2 = f1 + 1;
        System.out.println("f2:" + f2);// f2:4.23432416E8
        if (f1 == f2) {
            System.out.println("f1==f2");
        } else {
            System.out.println("f1!=f2");
        }
    }
}
