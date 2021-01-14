package 基础面试.JUC.locks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache {
    //缓存应用的资源，必须使用volatile修饰
    private volatile Map<String, Object> map = new HashMap<>();
    //加入读写锁
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    /**
     * 模拟写锁上锁解锁
     */
    public void put(String key, Object value) {
        //写锁上锁
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入，不可共享");
            map.put(key, value);
            //模拟网络拥堵
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //写锁解锁
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 模拟读锁上锁解锁
     */
    public void get(String key) {
        //读锁上锁
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取，可共享");
            Object result = map.get(key);
            //模拟网络拥堵
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "\t 读取完成：" + result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //读锁解锁
            readWriteLock.readLock().unlock();
        }
    }
}