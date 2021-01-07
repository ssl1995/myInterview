package atguigu.session2;

        import java.util.concurrent.locks.AbstractQueuedSynchronizer;
        import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ssl
 * @date 2020/3/15 17:14
 */
public class AbstractQueueSynDemo extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);
    }
}
