package atguigu.session2.blockingQueue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        //add/remove/element：会抛出异常:IllegalStateException,一言不合就报异常不推荐使用
        blockingQueue.add("1");
        blockingQueue.add("2");
        blockingQueue.add("3");
        // 再add一个元素就会抛出：IllegalStateException：Queue full
        blockingQueue.add("4");
        System.out.println(blockingQueue.add("4"));
        System.out.println("-------------------");

        //offer/poll/peek:失败返回布尔型
        blockingQueue.offer("11");
        blockingQueue.offer("12");
        blockingQueue.offer("13");
        // 失败返回布尔值：false
        System.out.println( blockingQueue.offer("14"));
        System.out.println("-------------------");

        //put/take:满了就一直等待，等待是为了只要有数据出去立马添加
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        // 满了添加就会一直阻塞等待，只有take出一个元素才能继续put
        System.out.println(blockingQueue.take());
        blockingQueue.put("d");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println("-------------------");

        //offer/poll设置失败等待时间
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    }
}
