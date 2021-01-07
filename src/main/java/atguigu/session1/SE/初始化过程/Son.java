package atguigu.session1.SE.初始化过程;


public class Son extends Father {
    // 类初始化 默认先去执行父类的非静态方法、代码块，但是被子类重写的不执行
    //8 父类类初始化完成，顺序执行子类非静态方法，又输出一遍9
    private int i = test();
    private static int j = method();

    //4 静态代码块
    static {
        System.out.print("(6)");
    }
    // 10 子类构造方法
    Son() {

        System.out.print("(7)");
    }
    // 9 子类非静态代码块
    {
        System.out.print("(8)");
    }

    //5 被重写的非静态方法test方法
    public int test() {
        System.out.print("(9)");
        return 1;
    }

    //3 静态方法
    public static int method() {
        System.out.print("(10)");
        return 1;
    }

    public static void main(String[] args) {
        //实例化初始化过程1:包含子父类静态加载
        Son s1 = new Son();
        System.out.println();
        //实例化初始化过程2:不包含所有的静态加载
        Son s2 = new Son();
        /*
        结果
        (5)(1)(10)(6)(9)(3)(2)(9)(8)(7)
        (9)(3)(2)(9)(8)(7)
        总结：
        类初始化：(5)(1)(10)(6)+实例初始化s1:(9)(3)(2)(9)(8)(7)
        实例初始化s2:(9)(3)(2)(9)(8)(7)
         */
    }
}
