package atguigu.session2.casAndAba;

import java.util.concurrent.atomic.AtomicReference;
//解决ABA问题1：使用原子引用类包装对象
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User u1 = new User("张三", 18);
        User u2 = new User("李四", 28);
        //使用原子应用类,保证不会出现ABA问题
        AtomicReference<User> atomicReference = new AtomicReference<>();
        //设置原子应用类对象
        atomicReference.set(u1);
        //模仿CAS操作，看是否出现ABA问题
        boolean resultU1 = atomicReference.compareAndSet(u1, u2);
        boolean resultU2 = atomicReference.compareAndSet(u1, u2);
        /*
            true	User{userName='李四', age=28}
            false	User{userName='李四', age=28}
         */
        System.out.println(resultU1 + "\t" + atomicReference.get().toString());
        System.out.println(resultU2 + "\t" + atomicReference.get().toString());

    }
}
