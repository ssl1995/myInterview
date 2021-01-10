package atguigu.session2.locks;
// synchronized是可重入锁
public class SynchronizedDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMSG();
        },"线程一").start();
        new Thread(()->{
            phone.sendEmail();
        },"线程二").start();
        /*
        线程一：手机发消息了
        线程一：手机发邮件了
        线程二：手机发邮件了
         */
    }
}
