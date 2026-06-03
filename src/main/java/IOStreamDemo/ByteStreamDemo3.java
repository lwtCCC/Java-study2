package IOStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo3 {
    public static void main(String[] args) throws IOException {

        /*
        * 换行功能 \r\n任意一个都行，两个都写会空出一行
        * 续写功能
        * */

        FileOutputStream fos = new FileOutputStream("./src/main/java/IOStreamDemo/aaa.txt",true);
        String str1 = "\rjifeixue";
        byte[] arr1 = str1.getBytes();
        fos.write(arr1);

        String str2 = "\r\n";
        byte[] arr2 = str2.getBytes();
        fos.write(arr2);

        String str3 = "luoweita";
        byte[] arr3 = str3.getBytes();
        fos.write(arr3);

        fos.close();
    }
}
