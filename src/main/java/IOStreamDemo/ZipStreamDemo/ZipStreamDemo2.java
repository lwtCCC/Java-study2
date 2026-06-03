package IOStreamDemo.ZipStreamDemo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 压缩单个文件
        * */

        File src = new File("C:\\Users\\17585\\Desktop\\aaa.txt");
        File dest = new File("C:\\Users\\17585\\Desktop\\");
        zipFile(src,dest);

    }

    public  static void zipFile(File src, File dest) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(dest,"aaa.zip")));

        ZipEntry entry = new ZipEntry("aaa.txt");
        zos.putNextEntry(entry);
        FileInputStream fis = new FileInputStream(src);
        int i;
        while ((i = fis.read()) != -1) {
            zos.write(i);
        }
        fis.close();

        zos.closeEntry();
        zos.close();
    }
}
