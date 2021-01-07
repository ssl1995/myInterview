package atguigu.session2.threadPool;

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
        //1 利用中间人FutureTask先存放资源类
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableThread());
        //2 thread线程计算结果，调用Call返回值
        Thread thread1 = new Thread(futureTask, "线程一");
        Thread thread2 = new Thread(futureTask, "线程二");
        // 多个线程强一个futureTask，只运行一个Callable
        thread1.start();
        thread2.start();
        //3 main线程运算结果
        Integer add = 100;
        //重点：模拟等待thread走完，防止线程阻塞影响效率，类似自旋锁
        while (!futureTask.isDone()) {

        }
        //重点：最后使用futureTask.get获取值
        Integer result = futureTask.get();
        System.out.println(Thread.currentThread().getName() + "\t 求和结果：" + (add + result));
    }
}

// callable有返回值，目的是把复杂度高的线程给与提醒，绕开它，先去执行容易的线程
class CallableThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Come in Callable");
        TimeUnit.SECONDS.sleep(2);
        //callable有返回值
        return 100;
    }
}
