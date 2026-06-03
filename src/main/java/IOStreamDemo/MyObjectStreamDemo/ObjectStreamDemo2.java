package IOStreamDemo.MyObjectStreamDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectStreamDemo2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
        *
        * 反序列化流
        * */

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/java/IOStreamDemo/MyObjectStreamDemo/a.txt"));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o);

    }
}
