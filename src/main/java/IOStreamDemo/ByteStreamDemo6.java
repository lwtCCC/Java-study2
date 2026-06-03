package IOStreamDemo;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo6 {
    public static void main(String[] args) throws IOException {

        /*
        * 一次读取多个数据
        * */

        FileInputStream fis = new FileInputStream("./src/main/java/IOStreamDemo/aaa.txt");
        byte[] bytes = new byte[10];

        int len = fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes,0,len));

        int len1 = fis.read(bytes);
        System.out.println(len1);
        System.out.println(new String(bytes,0,len1));

        fis.close();

    }
}
