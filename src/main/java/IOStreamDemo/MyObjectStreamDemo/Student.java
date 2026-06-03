package IOStreamDemo.MyObjectStreamDemo;

import java.io.Serial;
import java.io.Serializable;

public class Student implements Serializable {

    @Serial
    private static final long serialVersionUID = -3536194268242959138L;
    private String name;
    private int age;
    //transient：瞬态关键字
    //不会把当前属性序列化到文件中
    private transient String address;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
