package IOStreamDemo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertStreamDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 用字节流读取数据，每次读一整行
        *
        *  * */

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/java/IOStreamDemo/g.txt"), "GBK"));
        String line;
        while ((line= br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}
