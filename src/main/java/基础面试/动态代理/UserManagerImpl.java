package 基础面试.动态代理;

public class UserManagerImpl implements UserManager {

    @Override
    public void addUser(String username, String password) {
        System.out.println("UserName：" + username + " PassWord:" + password);
    }
}
