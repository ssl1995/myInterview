package atguigu.session2.connection;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.UUID;

public class ConnectionNotSafeDemo {
    public static void main(String[] args) {
        // list资源被共享，必然线程不安全
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
        HashMap<Object, Object> map = new HashMap<>();
    }
}
