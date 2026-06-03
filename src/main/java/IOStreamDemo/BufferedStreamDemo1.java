package IOStreamDemo;

import java.io.*;

public class BufferedStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 字节缓冲流(一次读取一个数据)
        * */

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/java/IOStreamDemo/buf1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/java/IOStreamDemo/copyBuf1.txt"));

        int b;
        while((b = bis.read()) != -1){
            bos.write(b);
        }
        bis.close();
        bos.close();
    }
}
