package IOStreamDemo.TestDemo3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.util.ArrayList;

public class Test2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        /*
        *
        *  一次存储多个对象
        * */

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/IOStreamDemo/TestDemo3/a.txt"));
        ArrayList<Student> o = (ArrayList<Student>) ois.readObject();
        o.forEach(System.out::println);
        ois.close();
    }
}
