package atguigu.session1.JVM;

public class TestDynamicLoad {
    static {
        System.out.println("加载 TestDynamicLoad");
    }

    public static void main(String[] args) {
        // new A()就会加载和初始化A;
        new A();
        // B不会被加载和初始化，除非new
        B b = null;
    }
    /* 运行结果
        加载 TestDynamicLoad
        加载 A
        初始化 A
     */
}

class A {
    static {
        System.out.println("加载 A");
    }

    public A() {
        System.out.println("初始化 A");
    }

}
class B {
    static {
        System.out.println("加载 B");
    }

    public B() {
        System.out.println("初始化 B");
    }

}