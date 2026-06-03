package IOStreamDemo.ZipStreamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipStreamDemo1 {
    public static void main(String[] args) throws IOException {
        /*
         *
         * 解压缩流
         * */

        File src = new File("C:\\Users\\17585\\Desktop\\FileJava.zip");
        File dst = new File("C:\\Users\\17585\\Desktop\\FileJava1");
        zipFile(src, dst);

    }

    public static void zipFile(File src, File dst) throws IOException {
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));

        ZipEntry nextEntry;
        while ((nextEntry = zip.getNextEntry()) != null) {
            if (nextEntry.isDirectory()) {
                new File(dst.getPath(), nextEntry.toString()).mkdirs();
            } else {
                FileOutputStream fos = new FileOutputStream(new File(dst, nextEntry.toString()));
                int len;
                while ((len = zip.read()) != -1) {
                    fos.write(len);
                }
                fos.close();
            }
            zip.closeEntry();
        }
        zip.close();
    }
}
