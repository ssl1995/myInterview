package atguigu.session1.SE.成员变量和局部变量;

public class Test {
    static int s;//静态成员变量-类变量
    int i;//成员变量，实例变量
    int j;//成员变量，实例变量

    {
        //局部变量和成员变量重名，用this.i表示实例变量
        int i = 1;//重新定义了一个新的i=局部变量，作用域结束就释放
        i++;//就近原则，执行完代码块的值消失
        j++;
        s++;
    }

    public void test(int j) {
        i++;
        //形参=局部变量，原j不会发生改变
        j++;
        s++;
    }

    public static void main(String[] args) {//args=局部变量
        Test obj1 = new Test();//obj1=局部变量
        Test obj2 = new Test();//obj2=局部变量
        obj1.test(10);
        obj1.test(20);
        obj2.test(30);
        /* obj1:2,1,5
             i:obj1执行2次，成员变量i=2
             j:test中的形参j是栈中，用完就释放，不会改变原来的j，j=1
             s:类变量，执行两次实例化和三次调用方法，所以s=5
         */
        System.out.println(obj1.i + "," + obj1.j + "," + obj1.s);
        // obj2：1,1,5 ,分析理由同上
        System.out.println(obj2.i + "," + obj2.j + "," + obj2.s);
    }
}
