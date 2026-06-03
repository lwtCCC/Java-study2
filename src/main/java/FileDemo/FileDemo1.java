package FileDemo;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
/*
        1.根据文件路径创建对象
        2.父路径字符串 + 子路径字符串
        3.父路径对象 + 子路径对象
*/
        File file1 = new File("C:\\Users\\17585\\Desktop\\aaa.txt");


        File file2 = new File("C:\\Users\\17585\\Desktop", "bbb.txt");

        String parent = "C:\\Users\\17585\\Desktop";
        File parentFile = new File(parent);
        File file3 = new File(parentFile, "bbb.txt");


    }
}
