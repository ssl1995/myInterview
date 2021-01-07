package atguigu.session2.blockingQueue;

// 传统版2.0的消费者生产者模式
public class ProviderConsumer_TraditionDemo {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.increment();
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"A").start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    shareData.decrement();
                }catch (Exception e){
                    e.printStackTrace();
                }
            },"B").start();
        }
    }
}
