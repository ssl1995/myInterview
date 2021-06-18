package ssl.JUC.locks;


public class ReadWriteLockDemo {
    public static void main(String[] args) {
        //模拟读写锁：主要是学习map用volatile修饰
        MyCache cache = new MyCache();
        //写锁：独占
        for (int i = 1; i <= 5; i++) {
            final int tempInt = 1;
            new Thread(() -> {
                cache.put(tempInt + "", tempInt + "");
            }, String.valueOf(i)).start();
        }
        //读锁：可共享
        for (int i = 1; i <= 5; i++) {
            final int tempInt = 1;
            new Thread(() -> {
                cache.get(tempInt + "");
            }, String.valueOf(i)).start();
        }
    }
}
