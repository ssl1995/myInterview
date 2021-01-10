package atguigu.session2.locks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        // ReentrantLock()空参就是非公平锁
        ReentrantLock lock1 = new ReentrantLock();
        // ReentrantLock(true):公平锁,性能下降，但是顺序得到保障
        ReentrantLock lock2 = new ReentrantLock(true);
        // 观看资源类里的lock加锁可重入
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
