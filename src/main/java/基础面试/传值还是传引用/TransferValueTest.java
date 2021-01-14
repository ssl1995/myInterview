package 基础面试.传值还是传引用;

public class TransferValueTest {
    public static void main(String[] args) {

        TransferValueTest test = new TransferValueTest();
        // 传基本类型，原值不会改变，原理是栈中传递的方法会复制基本类型到方法中
        int age = 1;
        test.changeValue1(age);
        System.out.println("age:" + age);
        // 传字符串，原值不会改变，原理是常量池中的字符串添加，会重新生成一个新的字符串去指向
        String str1 = "123";
        test.changeValue3(str1);
        System.out.println("str1:" + str1);
        // 传Bean，原值会发生改变，原理是原对象地址和方法中新的对象地址，都是去修改同一个成员变量值
        Person person = new Person(1, "A");
        test.changeValue2(person);
        System.out.println("personName;" + person.getPersonName());
    }

    public void changeValue1(int age) {
        age = 2;
    }

    public void changeValue2(Person person) {
        person.setPersonName("B");
    }

    public void changeValue3(String str) {
        str = "ABC";
    }
}
