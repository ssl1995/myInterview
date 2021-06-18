package 基础面试.深拷贝和浅拷贝;

import java.io.*;

public class Dancer implements Cloneable, Serializable {
    private String name;
    private Dancer partner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dancer getPartner() {
        return partner;
    }

    public void setPartner(Dancer partner) {
        this.partner = partner;
    }

    public Dancer deepClone() throws IOException, ClassNotFoundException {
        // 序列化:将内存中的对象序列化为字节数组
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 反序列化:将字节数组转回到对象，同时完成深拷贝的任务
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Dancer) ois.readObject();
    }

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Dancer d1 = new Dancer();
        d1.setName("张三");
        Dancer d2 = new Dancer();
        d2.setName("李四");
        d1.setPartner(d2);
        // Clone()是浅复制
        Dancer d1ShallowClone = (Dancer) d1.clone();
        System.out.println("d2:" + d2.hashCode());
        System.out.println("浅复制:" + d1ShallowClone.getPartner().hashCode());
        // 字节实现一个深拷贝
        Dancer d1DeepClone = (Dancer) d1.deepClone();
        System.out.println("深拷贝:" + d1DeepClone.getPartner().hashCode());

    }
}
