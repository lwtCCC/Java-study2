package FileDemo;

import java.io.File;

public class FileDemo4 {
    public static void main(String[] args) {
        /*
        *  删除文件
        *   删除空文件夹
        * */


        File file = new File("C:\\Users\\17585\\Desktop\\FileJava\\test1.txt");
        boolean b = file.delete();
        System.out.println(b);

    }
}
