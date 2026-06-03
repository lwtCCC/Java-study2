package FileDemo;

import java.io.File;

public class FileDemo5 {
    public static void main(String[] args) {
        /*
        *   遍历文件夹
        *       如果是空文件夹，返回长度为0的数组
        *       如果是文件，返回null
        *       路径不存在，返回null
        *       返回所有该文件夹下的所有文件和文件夹，包含隐藏的文件
        *       当访问需要权限才能获取的文件夹时，返回null
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");

        File[] files = file.listFiles();
        for (File value : files) {
            System.out.println(value);
        }

        /*File file1 = new File("C:\\Users\\17585\\Desktop\\FileJava\\test2.txt");

        File[] files1 = file1.listFiles();//路径是文件时返回null
        for (File value : files1) {
            System.out.println(value);
        }*/
    }
}
