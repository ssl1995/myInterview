package atguigu.session2.jvm;

public class printGCDetailsDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("打印");
        System.out.println("------------");
        //-Xms10m -Xmx10m -XX:+PrintGCDetails
        byte[] outOfMemory = new byte[20*1024*1024];
        //XX：+PrintGCDetails;XX:MetaSpaceSize=12m
       /* Thread.sleep(Integer.MAX_VALUE);*/
    }
}
