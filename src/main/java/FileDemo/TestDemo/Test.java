package FileDemo.TestDemo;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        /*
        * 创建文件
        * */
        File file = new File("./src/main/java/FileDemo/TestDemo/aaa.txt");
        boolean b = file.createNewFile();
        System.out.println(b);
    }
}
