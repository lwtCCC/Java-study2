package FileDemo.TestDemo;

import java.io.File;

public class Test2 {
    public static void main(String[] args) {

        /*
        * 遍历查找文件（包含子文件夹）
        *
        * */
        File file = new File("C:\\Users\\17585\\Desktop\\FileJava\\aaa");
        boolean b = haveTxt(file);
        System.out.println(b);

        File file1 = new File("C:\\");
        boolean b1 = haveTxt(file1);
        System.out.println(b1);
    }

    public static boolean haveTxt(File file) {
        File[] files = file.listFiles();
        /*
        * 空文件夹返回false
        * */
        if (files == null) return false;
        /*
        * 遍历获取所有文件
        * */
        for (File f : files) {
            /*
            * 判断是文件还是文件夹
            *   文件直接判断
            *   文件夹递归
            * */
            if (f.isFile()) {
                if (f.getName().endsWith(".java")) return true;
            }else {
                /*
                * 因为默认为false，所以只要找到就行，因此b只要赋值一次
                * */
                if (haveTxt(f)) return true;
            }
        }
        return false;
    }
}
