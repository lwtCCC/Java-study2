package IOStreamDemo.PrintStreamDemo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStreamDemo2 {
    public static void main(String[] args) throws IOException {

        /*
        *
        * 字符打印流
        * */

        PrintWriter pw = new PrintWriter(new FileWriter("src/main/java/IOStreamDemo/PrintStreamDemo/b.txt"), true);
        pw.println("Hello World");
        pw.close();
    }
}
