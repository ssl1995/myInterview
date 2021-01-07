package atguigu.session2.TransValueOrReference;

public class TransferValueTest {

    public static void main(String[] args) {
        TransferValueTest test = new TransferValueTest();
        //传基本类型，传的是副本，原值不会变
        int age = 20;
        test.changeValue1(age);
        System.out.println("age:" + age);

        //传bean，传的是地址值，原值会发生改变
        Person person = new Person(1, "张三");
        test.changeValue2(person);
        System.out.println("personName;" + person.getPersonName());

        //传字符串，String和包装类是final修饰的，无论是new或者""，都不会发生改变
        String str1 = new String("1231");
        test.changeValue3(str1);
        System.out.println("str1:" + str1);
        String str2 = "ABC";
        test.changeValue3(str2);
        System.out.println("str2:" + str2);
    }

    public void changeValue1(int age) {
        age = 10;
    }

    public void changeValue2(Person person) {
        person.setPersonName("张三改");
    }

    public void changeValue3(String str) {
        str = "字符串";
    }
}
