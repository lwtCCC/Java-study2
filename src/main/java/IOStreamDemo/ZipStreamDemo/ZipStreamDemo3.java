package IOStreamDemo.ZipStreamDemo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStreamDemo3 {
    public static void main(String[] args) throws IOException {
        /*
         *
         * 压缩多个文件
         * */

        File src = new File("C:\\Users\\17585\\Desktop\\FileJava");
        String p = src.getParent();
        File dest = new File(p, src.getName()+".zip");
        String name = src.getName();

        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        toZip(src, zos, name);

        zos.close();


    }

    public static void toZip(File src, ZipOutputStream zos, String name) throws IOException {

        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(name+"\\"+file.getName());
                zos.putNextEntry(zipEntry);
                FileInputStream fis = new FileInputStream(file.getPath());
                int len;
                while ((len = fis.read()) != -1) {
                    zos.write(len);
                }
                fis.close();
                zos.closeEntry();
            } else {
                toZip(file, zos, name+"\\"+file.getName());
            }
        }

    }
}
