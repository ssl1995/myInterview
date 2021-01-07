package 反射.init;

public class Father {
    private int i = test();
    private static int j = method();

    // 父类静态方法
    public static int method(){
        System.out.print("(5)");
        return 1;
    }
    // 执行父类静态代码块
    static{
        System.out.print("(1)");
    }
    // 被重写的方法，去子列执行，父类不执行
    public int test(){
        System.out.print("(4)");
        return 1;
    }
    // 非静态代码块
    {
        System.out.print("(3)");
    }
    // 父类构造方法
    Father(){
        System.out.print("(2)");
    }
}
