package atguigu.session1.SE.自增变量;

public class AddTest {
    public static void main(String[] args) {
        int i = 1;
        i = i++;// i=1
        int j = i++;//j=1,但是i=2
        int k = i + (++i * i++);//k = 2 + (3 * 3）=11
        System.out.println("i=" + i);// i =4
        System.out.println("j=" + j);//j = 2
        System.out.println("k=" + k);// k =9
    }
}
