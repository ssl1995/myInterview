package atguigu.session2.jvm;

public class PrintInitialAndMaxMemoryDemo {
    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("jvm默认初始化内存约为1/64:" + (initialMemory /(double) (1024 * 1024)) + "m");
        System.out.println("jvm默认最大化内存约为1/4:" + (maxMemory / (double)(1024 * 1024) + "m"));
    }
}
