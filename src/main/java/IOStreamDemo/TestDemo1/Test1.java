package IOStreamDemo.TestDemo1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {

        /*
         * 拷贝文件夹（包含子文件夹）
         * */

        //获取文件对象
        File src = new File("C:\\Users\\17585\\Desktop\\FileJava\\aaa");//要拷贝的文件
        File dest = new File("C:\\Users\\17585\\Desktop\\FileJava\\copy");//目的文件

        copyFile(src, dest);


    }

    public static void copyFile(File src, File dest) throws IOException {

        File[] files = src.listFiles();

        if (files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    // 创建目录
                    File dest1 = new File(dest.getAbsolutePath(),file1.getName());
                    dest1.mkdirs();

                    copyFile(file1, dest1);// 递归
                } else {
                    FileInputStream fis = new FileInputStream(file1);//要读的文件
                    FileOutputStream fos = new FileOutputStream(dest.getAbsolutePath()+"\\"+file1.getName());//要写的文件,文件不存在会被自动创建
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = fis.read(bytes)) != -1) {
                        fos.write(bytes, 0, len);
                    }
                    fis.close();
                    fos.close();
                }
            }
        }
    }


}
