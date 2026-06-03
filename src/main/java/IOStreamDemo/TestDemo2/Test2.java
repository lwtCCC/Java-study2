package IOStreamDemo.TestDemo2;

import java.io.*;

public class Test2 {
    public static void main(String[] args) throws IOException {

        /*
        *
        * 文件打开次数计算
        *
        * */

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/IOStreamDemo/TestDemo2/q.txt"));
        String s = br.readLine();
        br.close();

        int count = Integer.parseInt(s);
        count += 1;
        System.out.println("第"+count+"次打开游戏");
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/IOStreamDemo/TestDemo2/q.txt"));
        bw.write(count+"");
        bw.close();

    }
}
