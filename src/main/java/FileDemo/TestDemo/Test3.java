package FileDemo.TestDemo;

import java.io.File;

public class Test3 {
    public static void main(String[] args) {

        /*
        * 删除文件夹
        *
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava\\aaa");
        boolean deleted = deleted(file);
        System.out.println(deleted);
    }

    public static boolean deleted(File file) {
        boolean b = false;
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    deleted(f);
                }else{
                    f.delete();
                }
            }
            b = file.delete();
        }
        return b;
    }
}
