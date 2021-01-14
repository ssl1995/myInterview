package atguigu.session2.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResources3 {
    // 标识位，进行生产+消费，volatile保证可见性
    private volatile boolean FLAG = true;
    // 多线程使用AtomicInteger，不用int
    private AtomicInteger atomicInteger = new AtomicInteger();
    // 生产环境：不能具体使用7种具体类
    BlockingQueue<String> blockingQueue = null;

    // 生产环境：穿接口
    public MyResources3(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        // 输出/日志打印一下，便于排查
        System.out.println(blockingQueue.getClass().getName());
    }

    public void provider() throws Exception {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (retValue) {
                System.out.println(Thread.currentThread().getName() + "\t 插入数据：" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入数据：" + data + "失败");
            }
            //生产休息，等待消费
            TimeUnit.SECONDS.sleep(1);
        }
        //生产永久结束
        System.out.println(Thread.currentThread().getName() + "\t生产结束，不再生产");
    }

    public void consumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            //消费永久结束队=列里面没有值，消费也失败，就将标识改为false
            if (result == null || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t没有产品，消费退出");
                return;//退出
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费数据：" + result + "成功");
        }
    }
    public void stop() {
        this.FLAG = false;
    }

}