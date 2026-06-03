package IOStreamDemo;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo2 {
    public static void main(String[] args) throws IOException {

        /*
        * 字符流一次读取多个数据
        *   读取，解码，转换一次性完成
        * */

        FileReader fr = new FileReader("./src/main/java/IOStreamDemo/ccc.txt");
        char[] chars = new char[10];
        int len;
        while((len = fr.read(chars)) != -1){
            System.out.print(new String(chars,0,len));
        }
        fr.close();
    }
}
