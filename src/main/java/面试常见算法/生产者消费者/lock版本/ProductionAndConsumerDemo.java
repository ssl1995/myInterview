package 面试常见算法.生产者消费者.lock版本;

public class ProductionAndConsumerDemo {
    public static void main(String[] args) {
        //MyResources1 myResources = new MyResources1();
        MyResources2 myResources = new MyResources2();

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    myResources.productor();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "线程1").start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                try {
                    myResources.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "线程2").start();
        }
    }
}
