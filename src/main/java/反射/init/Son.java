package 反射.init;


public class Son extends Father {
    private int i = test();
    private static int j = method();

    // 执行子列静态方法
    public static int method() {
        System.out.print("(10)");
        return 1;
    }
    // 执行子类非静态代码块
    static {
        System.out.print("(6)");
    }
    // 被重写的非静态方法方法被执行2次
    @Override
    public int test() {
        System.out.print("(9)");
        return 1;
    }
    // 子类非静态代码块
    {
        System.out.print("(8)");
    }
    // 子类构造方法
    Son() {
        System.out.print("(7)");
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println();
        // 静态方法只执行一次
        Son s2 = new Son();
    }
}
