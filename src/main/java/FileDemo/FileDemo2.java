package FileDemo;

import java.io.File;
import java.text.SimpleDateFormat;

public class FileDemo2 {
    public static void main(String[] args) {
        /*
        *   1.文件是否存在
        *   2.文件对象是目录？
        *   3.文件对象是文件？
        *   4.文件大小，只能获取文件的大小，文件夹不行，不会报错，但是返回值为0
        *   5.文件名字
        *   6.文件上次修改时间
        *   7.定义文件时的文件地址
        *   8.文件绝对地址
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        long length = file.length();
        System.out.println(length);
        File absoluteFile = file.getAbsoluteFile();
        System.out.println(absoluteFile);
        String path = file.getPath();
        System.out.println(path);
        String name = file.getName();
        System.out.println(name);
        System.out.println("--------------------------------");


        File file1 = new File("src\\main\\java\\aaa.txt");
        System.out.println(file1.exists());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        long l = file.lastModified();
        System.out.println(l);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(l));
    }
}
