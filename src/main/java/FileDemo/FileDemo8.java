package FileDemo;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo8 {
    public static void main(String[] args) {
        /*
         * 遍历获取文件（完整地址）
         * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");

        /*File[] files = file.listFiles();

        for (File file1 : files) {
            if (file1.isFile() && file1.getName().endsWith(".txt")) {
                System.out.println(file1.getAbsolutePath());
            }
        }*/

        /*File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });*/


        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.getName().endsWith(".txt");
            }
        });

        System.out.println(Arrays.toString(files));
    }
}
