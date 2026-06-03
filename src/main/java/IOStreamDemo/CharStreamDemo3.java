package IOStreamDemo;

import java.io.FileWriter;
import java.io.IOException;

public class CharStreamDemo3 {
    public static void main(String[] args) throws IOException {

        /*
        * 字符输出流
        * */

        FileWriter fw = new FileWriter("./src/main/java/IOStreamDemo/ddd.txt",true);
        fw.write(100);
        fw.write('c');
        fw.write("你好q");
        fw.write("世界的今天",0,2);
        char[] chars = {'a','b','c','我'};
        fw.write(chars);
        fw.write(chars,0,2);
        fw.close();
    }
}
