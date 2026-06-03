package IOStreamDemo.TestDemo2;

import java.io.*;
import java.util.*;

public class Test1Case2 {
    public static void main(String[] args) throws IOException {

        /*
        * 争对Test1中的题目的方法2
        * */

        BufferedReader br = new BufferedReader(new FileReader("src/main/java/IOStreamDemo/TestDemo2/a.txt"));
        //TreeMap方案
        /*TreeMap<Integer, String> map = new TreeMap<>();
        String str;
        while ((str = br.readLine()) != null){
            map.put(Integer.parseInt(str.split("\\.")[0]), str);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/IOStreamDemo/TestDemo2/a2.txt"));


        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            bw.write(entry.getValue());
            bw.newLine();
        }*/

        //TreeSet方案
        TreeSet<String> treeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int k1 = Integer.parseInt(o1.split("\\.")[0]);
                int k2 = Integer.parseInt(o2.split("\\.")[0]);
                return k1 - k2;
            }
        });
        String line;
        while ((line = br.readLine()) != null) {
            treeSet.add(line);
        }

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/IOStreamDemo/TestDemo2/a3.txt"));
        for (String s : treeSet) {
            bw.write(s);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
