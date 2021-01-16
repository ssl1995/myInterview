package 基础面试.JUC.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * Callable和Runnable区别：
 * 1 返回值；Runnable没有返回值，Callable有返回值，返回值存在的意义是调用Callable接口的线程结束后返回值
 * 2 重写方法：Runnable是run，Callable和call
 * 3 调用形式：Callable 在Thread中没有构造方法支持，所以使用FutureTask作为中间人传入，再作为参数传入Thread
 */
public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1.Callable利用中间人FutureTask先存放资源类
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableThread());
        Thread thread1 = new Thread(futureTask, "线程一");
        Thread thread2 = new Thread(futureTask, "线程二");
        // 2.多个线程强一个futureTask，只运行一个Callable
        thread1.start();
        thread2.start();
        // 3.main线程模拟器其他线程的运算结果
        Integer otherRes = 100;
        // 4.FutureTask使用方法：使得CallableThread执行完再走，防止其余线程阻塞影响效率
        while (!futureTask.isDone()) {

        }
        // 5.获取CallableThread执行结果
        Integer res = futureTask.get();
        System.out.println(Thread.currentThread().getName() + "\t 所有线程的计算结果：" + (otherRes + res));
    }
}

// 创建线程方式3：
class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("多个线程抢一个futureTask，只有有一个进入。Come in Callable");
        TimeUnit.SECONDS.sleep(2);
        return 100;
    }
}

// 创建线程方式2：
class RunnableThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable,没有返回值");
    }
}

// 创建线程方式1：
class ThreadDemo extends Thread {

}
