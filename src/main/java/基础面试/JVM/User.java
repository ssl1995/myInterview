package 基础面试.JVM;

public class User {
    private String userName ;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void print(){
        System.out.println("MyStaticCL加载的User.print方法");
    }
}
