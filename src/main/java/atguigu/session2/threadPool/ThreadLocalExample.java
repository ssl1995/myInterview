package atguigu.session2.threadPool;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalExample implements Runnable{
    // SimpleDateFormat 不是线程安全的，所以每个线程都要有⾃⼰独⽴的副本
    private static final
    ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd：HH-mm"));

    public static void main(String[] args) throws InterruptedException {
        //obj=资源类
        ThreadLocalExample obj = new ThreadLocalExample();
        for(int i=0 ; i<10; i++){
            //创建10个线程
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }
    @Override
    public void run() {
        System.out.println("线程名："+Thread.currentThread().getName()+"初试时间，每个线程都该一样= "+formatter.get().toPattern());
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        formatter.set(new SimpleDateFormat());
        System.out.println("线程名："+Thread.currentThread().getName()+"当前时间= "+formatter.get().toPattern());
    }
}