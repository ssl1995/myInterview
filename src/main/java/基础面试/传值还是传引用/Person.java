package 基础面试.传值还是传引用;

public class Person {
    private Integer age;
    private String personName;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Person() {
    }

    public Person(Integer age, String personName) {
        this.age = age;
        this.personName = personName;
    }
}
