package IOStreamDemo;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo1 {
    public static void main(String[] args) throws IOException {

        /*
        *
        * 转换流，按照指定编码进行读取文件
        * */

        //转换流 Java11之前用的转换
        InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/java/IOStreamDemo/g.txt"), "gbk");

        int ch;
        while ((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        isr.close();
        System.out.println();


        //字节流 基于前面知识的手动转换编码
        /*FileInputStream fis = new FileInputStream("src/main/java/IOStreamDemo/g.txt");
        FileOutputStream fos = new FileOutputStream("src/main/java/IOStreamDemo/g1.txt");
        int len;
        byte[] bytes = new byte[2];
        while ((len = fis.read(bytes)) != -1){
            //System.out.print(new String(bytes, 0, len,"gbk"));
            fos.write(bytes,0,len);
        }
        fis.close();
        fos.close();*/

        //字符流 默认是utf-8，但是可以指定类型
        FileReader fr = new FileReader("src/main/java/IOStreamDemo/g.txt", Charset.forName("gbk"));
        int len;
        while ((len = fr.read()) != -1){
            System.out.print((char)len);
        }
        fr.close();


    }
}
