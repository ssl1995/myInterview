package 基础面试.JUC.learnVolatile;

public class ReSortDemo {
    int a;
    boolean flag = false;

    public void method1() {
        // 这里可能出现指令重排问题：
        // 线程一：编译器优化使得，flag先为true，然后线程二走method2进去，a=0+1=1,出现线程不安全的问题
        a = 1;
        flag = true;
    }

    public void method2() {
        if (flag) {
            a = a + 1;
            System.out.println("最终的a:" + a);
        }
    }
    void resetSort() {
        int a = 1; // 语句1
        int b = 2; // 语句2
        int x = a + 1;// 语句3
        int y = a * a;// 语句4

        /* 指令重排：编译器优化、会将语句顺序打乱
           重排可能性：1234、1324、2134
           但是4是不能在1之前的，因为编译器优化会保证数据结果之间的依赖性
         */
    }
}
