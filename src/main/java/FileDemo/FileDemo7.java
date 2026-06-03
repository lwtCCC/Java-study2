package FileDemo;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FileDemo7 {
    public static void main(String[] args) {

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");

        String[] list = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                File file = new File(dir, name);
                return file.getAbsolutePath().endsWith(".txt");
            }
        });

        /*String[] list = file.list((File dir, String name) -> name.endsWith(".txt"));*/

        /*String[] list = file.list(FileDemo7::listFiles);*/

        System.out.println(Arrays.toString(list));

    }


    public static boolean listFiles(File dir,String name) {
        return name.endsWith(".txt");
    }
}
