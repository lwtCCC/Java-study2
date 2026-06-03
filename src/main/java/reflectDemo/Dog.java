package reflectDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Dog {
    private String name;
    private int age;

    private void eat(){
        System.out.println("狗的方法1");
    }

    public String eat(String name){
        System.out.println("狗的方法2");
        return name;
    }

    private Dog() {
        System.out.println("无参构造被执行了");
    }

    public Dog(String name) {
        System.out.println("单个参数的构造器被执行了");
        this.name = name;
    }

    public Dog(String name, int age) {
        System.out.println("全参构造器被执行了");
        this.name = name;
        this.age = age;
    }
}
