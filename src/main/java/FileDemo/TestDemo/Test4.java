package FileDemo.TestDemo;

import java.io.File;

public class Test4 {
    public static void main(String[] args) {
        /*
        * 统计文件夹的大小
        *
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");

        long l = lenFile(file);
        System.out.println(l);
    }

    public static long lenFile(File file){
        File[] files = file.listFiles();
        long len = 0;
        if(files == null){
            return 0;
        }
        for (File file1 : files) {
            if (file1.isDirectory()) {
                len += lenFile(file1);
            }else{
                len += file1.length();
            }
        }
        return len;
    }
}
