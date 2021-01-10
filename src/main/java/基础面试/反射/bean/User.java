package 基础面试.反射.bean;
import java.util.Date;

public class User {
    private int id=1;
    private String name="张三";
    private static Date date;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    private User(String name) {
        this.name = name;
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void fun1() {
        System.out.println("无参的fun1被调用");
    }

    public void fun2(int id) {
        System.out.println("fun2:" + id);
    }

    public void fun3(int id, String s) {
        System.out.println("fun3:" + id + "," + s);
    }

    private void fun4(Date date) {
        System.out.println("fun4:" + date);

    }

    public static void fun5() {
        System.out.println("fun5");
    }

    public static void fun6(String[] args) {
        System.out.println(args.length);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Date getDate() {
        return date;
    }

    public static void setDate(Date date) {
        User.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
