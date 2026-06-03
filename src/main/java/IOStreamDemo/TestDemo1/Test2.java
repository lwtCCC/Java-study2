package IOStreamDemo.TestDemo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {

        /*
         * 加密文件,解密文件
         *
         * */

        /*//加密
        FileInputStream fis = new FileInputStream("src/main/java/IOStreamDemo/TestDemo1/lwt1.jpg");
        FileOutputStream fos = new FileOutputStream("src/main/java/IOStreamDemo/TestDemo1/ency.jpg");
        int i;
        while ((i = fis.read()) != -1) {
            fos.write(i ^ 10);
        }
        fis.close();
        fos.close();*/

        //解密
        FileInputStream fis1 = new FileInputStream("src/main/java/IOStreamDemo/TestDemo1/ency.jpg");
        FileOutputStream fos1 = new FileOutputStream("src/main/java/IOStreamDemo/TestDemo1/redu.jpg");
        int i1;
        while ((i1 = fis1.read()) != -1) {
            fos1.write(i1 ^ 10);
        }
        fis1.close();
        fos1.close();
    }
}
