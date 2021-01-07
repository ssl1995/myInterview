package atguigu.session2.connection;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
/** 集合类并发不安全：
 1 故障现象
 ConcurrentModification异常
 2 导致原因
 并发争抢修改导致，参考举例的花名册的例子
 一个人正在写入，另一个人同学过来争抢，导致的数据不一致= 并发修改异常
 3 解决方法
 1：使用vector，但是是jdk1.0当时古老的集合了，早不使用了
 2：使用工具类：Collections.synchronizedList(list);
 3：使用读写复制锁：new CopyOnWriteArrayList<>();
     底层源码解析：读写分离，写完立马换到这里读，保证了线程安全
     public boolean add(E e) {
         synchronized (lock) {
             Object[] es = getArray();
             int len = es.length;
             es = Arrays.copyOf(es, len + 1);
             es[len] = e;
             setArray(es);
             return true;
         }
     }
 4 优化建议
 不要犯第二次错误
 */
public class ConnectionSafeDemo {

    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
