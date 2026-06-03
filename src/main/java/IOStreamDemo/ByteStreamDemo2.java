package IOStreamDemo;

import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo2 {
    public static void main(String[] args) throws IOException {

        /*
         * 一次性写入的多种方式
         *   1.直接写
         *   2.用字节数组装好再写入
         *   3.写入字节数组部分数据
         * */
        byte[] arr = {97,98,99,100}; //abcd
        FileOutputStream fos = new FileOutputStream("./src/main/java/IOStreamDemo/aa.txt");
        /*fos.write(arr);*/
        fos.write(arr,2,2);//off:起始索引    len:长度
        fos.close();

    }
}
