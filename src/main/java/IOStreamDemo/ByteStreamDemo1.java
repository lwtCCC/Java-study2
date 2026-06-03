package IOStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 字节输出流
        * 输出文字到本地文件
        *   字节流可以读取非纯文本文件
        *   字符流只能读纯文本文件
        *
        * */

        //1.创建对象,父级路径不存在会报错
        //如果文件存在，会清空文件（在创建对象时）
        FileOutputStream fos = new FileOutputStream("./src/main/java/IOStreamDemo/aa.txt");
        //2.写出数据
        String s = "中";
        byte[] bytes = s.getBytes();
        fos.write(bytes);
        //3.释放资源
        //不释放资源该文件会被Java占用，简而言之，无法操作
        fos.close();
    }
}
