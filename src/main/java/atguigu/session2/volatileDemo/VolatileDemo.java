package atguigu.session2.volatileDemo;

import java.util.concurrent.TimeUnit;
// 保证可见性
public class VolatileDemo {
    public static void main(String[] args) {
        //1 创建资源类，int被volatile修饰，对它的写操作可以立马被其他线程知道
        MyData myData = new MyData();

        //2 第一个线程AAA
        new Thread(() -> {
            // AAA come in
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停3s
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 调用资源类，num = 60
            myData.addTo();
            System.out.println(Thread.currentThread().getName() + "\t updated number 成员变量和局部变量:" + myData.num);
        }, "AAA").start();

        //3 第二个线程就是=main，num没有使用volatile修饰的变量，此时这里一直循环，出不去
        while (myData.num == 0) {

        }
        //4 资源类中的num如果被volatile修饰，就会执行到这一句
        System.out.println(Thread.currentThread().getName() + "\t 已使用volatile修饰，mission is over");
    }
}
