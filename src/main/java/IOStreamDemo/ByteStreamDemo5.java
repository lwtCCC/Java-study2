package IOStreamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo5 {
    public static void main(String[] args) throws IOException {

        /*
         * 文件拷贝
         * */

        FileInputStream fis = new FileInputStream("./src/main/java/IOStreamDemo/aaa.txt");
        FileOutputStream fos = new FileOutputStream("./src/main/java/IOStreamDemo/copy.txt");

        int i;
        while ((i = fis.read()) != -1) {
            fos.write(i);
        }
        fis.close();
        fos.close();
    }
}
