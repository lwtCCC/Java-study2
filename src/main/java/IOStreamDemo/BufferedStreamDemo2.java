package IOStreamDemo;

import java.io.*;

public class BufferedStreamDemo2 {
    public static void main(String[] args) throws IOException {

        /*
        * 字节缓冲流(一次读取多个数据)
        * */

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/java/IOStreamDemo/buf1.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/main/java/IOStreamDemo/copyBuf2.txt"));
        byte[] bytes = new byte[100];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }
        bis.close();
        bos.close();
    }
}
