package FileDemo.TestDemo;

import java.io.File;

public class Test1 {
    public static void main(String[] args) {
        /*
        * 定义方法，查找文件(不考虑子文件夹)
        * */

        File file = new File("C:\\Users\\17585\\Desktop\\FileJava");
        boolean b = haveTxt(file);
        System.out.println(b);

    }

    public static boolean haveTxt(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            return false;
        }
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                return true;
            }
        }
        return false;
    }
}
