package 面试常见算法.生产者消费者.syn版本;

public class Consumer implements Runnable{
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }
    @Override
    public void run() {
        while (true) {
            store.poll();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
