package atguigu.session2.locks;

public class ReentrantLockDemo1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.run();
        },"线程一").start();
        /*
         线程一:进入了get方法
         线程一:进入了get1方法
         */
    }
}
