package atguigu.session2.locks;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
        import java.util.concurrent.locks.ReentrantLock;


public class AbstractQueueSynDemo extends AbstractQueuedSynchronizer {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(false);
    }
}
