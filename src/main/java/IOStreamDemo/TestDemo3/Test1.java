package IOStreamDemo.TestDemo3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        * 一次存储多个对象
        *
        * */

        Student s1 = new Student("张三", 23, "南京");
        Student s2 = new Student("李四", 24, "北京");
        Student s3 = new Student("王五", 25, "天京");
        Student s4 = new Student("小八嘎", 26, "东京");
        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        //序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/IOStreamDemo/TestDemo3/a.txt"));
        oos.writeObject(list);
        oos.close();



    }
}
