package 面试常见算法.生产者消费者;

public class Store {
    private int count;
    private final int MAX_COUNT = 10;

    public synchronized void push() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存已满，停止生产");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count++;
        System.out.println(Thread.currentThread().getName() + " 生产者生产完毕，当前库存：" + count);
        // 唤醒对象的等待池中的所有线程
        notifyAll();
    }

    public synchronized void poll() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " 库存为0，停止消费");
                wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + " 消费者消费完毕，当前库存：" + count);
        // 唤醒对象的等待池中的所有线程
        notifyAll();
    }
}
