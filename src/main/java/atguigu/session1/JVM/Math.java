package atguigu.session1.JVM;

public class Math {
    public static final int initData = 666;
    public static User user = new User();

    // 一个成员方法对应一个栈帧内存区域
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }
}
