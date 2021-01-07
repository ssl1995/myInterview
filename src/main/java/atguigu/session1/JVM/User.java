package atguigu.session1.JVM;

public class User {
    private String userName;
    private int id;

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void sout() {
        System.out.println("自己的加载器加载调用方法");
    }
}
