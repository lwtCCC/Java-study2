package IOStreamDemo;

import java.io.FileReader;
import java.io.IOException;

public class CharStreamDemo1 {
    public static void main(String[] args) throws IOException {

        /*
        * 字符流读取文件
        *
        * */

        FileReader fid = new FileReader("./src/main/java/IOStreamDemo/bbb.txt");
        int b;
        while ((b = fid.read()) != -1) {
            System.out.print((char)b);
        }

        fid.close();

    }
}
