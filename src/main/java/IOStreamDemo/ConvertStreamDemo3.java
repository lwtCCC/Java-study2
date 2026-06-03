package IOStreamDemo;

import java.io.*;
import java.nio.charset.Charset;

public class ConvertStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 将GBK文件转换成UTF-8
        * */

        /*InputStreamReader isr = new InputStreamReader(new FileInputStream("src/main/java/IOStreamDemo/g.txt"), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/main/java/IOStreamDemo/g4.txt"), "utf-8");

        int ch;
        while((ch = isr.read()) != -1){
            osw.write(ch);
        }
        isr.close();
        osw.close();*/

        FileReader fr = new FileReader("src/main/java/IOStreamDemo/g.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("src/main/java/IOStreamDemo/g5.txt", Charset.forName("utf-8"));
        int ch;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }
        fr.close();
        fw.close();

    }
}
