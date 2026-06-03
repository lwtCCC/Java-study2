package IOStreamDemo;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class ConvertStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        * 转换流按照指定编码写入
        * */

        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/main/java/IOStreamDemo/g2.txt"), "gbk");
        osw .write("你好，世界");
        osw.close();

        FileWriter fw = new FileWriter("src/main/java/IOStreamDemo/g3.txt", Charset.forName("GBK"));
        fw.write("你好，世界!!!");
        fw.close();
    }
}
