package FileDemo;

import java.io.File;
import java.io.IOException;

public class FileDemo3 {
    public static void main(String[] args) throws IOException {

        /*
        *   1.创建文件
        *   2.创建 文件夹
        * */

        //创建新的空文件
        //如果文件已存在，不会报错，返回值为false
        //如果路径不存在，会报错
        File file = new File("./src/main/java/FileDemo/aaa.txt");
        boolean b = file.createNewFile();
        System.out.println(b);


        //如果路径存在，则无法创建，比如存在ccc（无后缀）文件，就无法创建ccc目录
        //mkdir 只能创建单级文件夹，无法创建多级文件夹
        File file1 = new File("C:\\Users\\17585\\Desktop\\FileJava\\ccc");
        boolean b1 = file1.mkdir();
        System.out.println(b1);

        //创建多级文件夹，如果路径中有不存在的，也会被创建出来
        File file2 = new File("C:\\Users\\17585\\Desktop\\FileJava\\aaa\\bbb\\ccc");
        boolean b2 = file2.mkdirs();
        System.out.println(b2);

    }
}
