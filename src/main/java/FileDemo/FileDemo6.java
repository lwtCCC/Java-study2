package FileDemo;

import java.io.File;
import java.util.Arrays;

public class FileDemo6 {
    public static void main(String[] args) {

        /*
        * 文件的遍历和获取
        *   获取根文件
        *   获取目录下的文件名
        *   文件过滤器
        *
        * */
        //获取系统根文件
        File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));

        //获取当前路径下的全部文件(只是获取名字)
        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");
        String[] list = file.list();
        System.out.println(Arrays.toString(list));


    }
}
