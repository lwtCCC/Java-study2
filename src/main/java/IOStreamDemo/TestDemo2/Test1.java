package IOStreamDemo.TestDemo2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 对文件内容进行序号排序
        * */

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/IOStreamDemo/TestDemo2/a.txt"));
        ArrayList<String> list = new ArrayList<>();
        String str;
        while ((str = br.readLine()) != null){
            list.add(str);
        }

        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                int k1 = Integer.parseInt(o1.split("\\.")[0]);
                int k2 = Integer.parseInt(o2.split("\\.")[0]);
                return k1 - k2;
            }
        });

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/IOStreamDemo/TestDemo2/a1.txt"));
        for (String s : list) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
