package IOStreamDemo.CommonsIODemo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class CommonsIODemo1 {
    public static void main(String[] args) throws IOException {

        /*
        *
        * 工具类
        * */

        //复制文件
        /*File src = new File("src/main/java/IOStreamDemo/CommonsIODemo/a.txt");
        File dest = new File("src/main/java/IOStreamDemo/CommonsIODemo/aCopy.txt");
        FileUtils.copyFile(src,dest);*/

        //复制文件夹
        File src = new File("C:\\Users\\17585\\Desktop\\FileJava\\aaa");
        File dest = new File("C:\\Users\\17585\\Desktop\\FileJava\\copy2");
        //FileUtils.copyDirectory(src, dest);//只拷贝目录里面的东西
        FileUtils.copyDirectoryToDirectory(src, dest);//原封不动拷贝，包括最外层的目录
    }
}
