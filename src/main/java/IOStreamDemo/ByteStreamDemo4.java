package IOStreamDemo;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteStreamDemo4 {
    public static void main(String[] args) throws IOException {

        /*
         * 字节输入流的用法
         * */

        FileInputStream fis = new FileInputStream("./src/main/java/IOStreamDemo/aaa.txt");
        /*int read = fis.read();//一次只能读一个,读出来的ASCII码表上对应的数字
        System.out.println(read);*/

        //读到最后会返回-1
        //先读取再移动指针
        /*while (true) {
            int i = fis.read();
            if (i == -1) {
                break;
            }
            System.out.print((char) i);
        }*/

        int i;
        while((i=fis.read())!=-1) {
            System.out.print((char)i);
        }
        fis.close();
    }
}
