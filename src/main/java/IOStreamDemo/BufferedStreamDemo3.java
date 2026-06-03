package IOStreamDemo;

import java.io.*;

public class BufferedStreamDemo3 {
    public static void main(String[] args) throws IOException {

        /*
        *
        * 字符缓冲流
        *   单个读取
        *   多个读取
        *   按行读取
        *   缓冲输入流的通用换行方式
        * */

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/IOStreamDemo/fff.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/IOStreamDemo/hhh.txt"));

        //单个读取
        /*int b;
        while ((b = br.read()) != -1){
            System.out.print((char) b);
        }*/

        //多个读取
        /*char[] bytes = new char[100];
        int len;
        while ((len = br.read(bytes)) != -1){
            System.out.println(new String(bytes,0,len));
        }*/

        //按行读取
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
