package atguigu.session2.casAndAba;

public class DoWhile {
    public static void main(String[] args) {
        boolean isTrue = true;
        int a = 1;
        do {
            a = 2;
        } while (!isTrue);
        // while(假)跳出循环,(真)继续循环
        System.out.println(a);
    }
}
