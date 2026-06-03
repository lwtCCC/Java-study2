package IOStreamDemo.MyObjectStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 序列化流
        * 存储对象信息
        *  对象类要实现Serializable接口
        * */

        Student stu = new Student("张三", 18);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/IOStreamDemo/MyObjectStreamDemo/a.txt"));
        oos.writeObject(stu);
        oos.close();
    }
}
