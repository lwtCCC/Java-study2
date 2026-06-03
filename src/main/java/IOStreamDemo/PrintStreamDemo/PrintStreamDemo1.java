package IOStreamDemo.PrintStreamDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        *
        * 字节打印流
        * */

        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/IOStreamDemo/PrintStreamDemo/a.txt",true));
        ps.println("Hello World");
        ps.print(true);
        ps.println();
        ps.println(97);
        ps.close();
    }
}
