package IOStreamDemo.TestDemo4;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
         *  网络爬虫
         *   爬取姓名
         * */

        String familyName = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String boyName = "http://www.haoming8.cn/baobao/10881.html";
        String girlName = "http://www.haoming8.cn/baobao/7641.html";

        String familyName1 = WebCrawler(familyName);
        String boyName1 = WebCrawler(boyName);
        String girlName1 = WebCrawler(girlName);

        ArrayList<String> familyTempName = getData(familyName1, "(\\W{4})(，|。)", 1);

        ArrayList<Object> familyNameList = new ArrayList<>();
        for (String s : familyTempName) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                familyNameList.add(c + "");
            }
        }
        System.out.println("familyNameList: " + familyNameList);

        ArrayList<String> boyTempName = getData(boyName1, "([\\u4e00-\\u9fa5·]{2})(、|。)", 1);
        ArrayList<String> boyNameList = new ArrayList<>();
        for (String s : boyTempName) {
            if (!boyNameList.contains(s)) {
                boyNameList.add(s);
            }
        }
        System.out.println("boyNameList: " + boyNameList);

        ArrayList<String> girlTempName = getData(girlName1, "([\\u4e00-\\u9fa5·]{2} ){4}[\\u4e00-\\u9fa5·]{2}", 0);
        ArrayList<String> girlNameList = new ArrayList<>();
        for (String s : girlTempName) {
            String[] s1 = s.split(" ");
            for (int i = 0; i < s1.length; i++) {
                girlNameList.add(s1[i]);
            }
        }
        System.out.println("girlNameList: " + girlNameList);

        ArrayList<String> list = getInfo(familyNameList, boyNameList, girlNameList, 70, 50);
        System.out.println("list: " + list);

        File file = new File("src/main/java/IOStreamDemo/TestDemo4/NameTest.txt");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (String s : list) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    private static ArrayList<String> getInfo(ArrayList<Object> familyNameList, ArrayList<String> boyNameList, ArrayList<String> girlNameList, int x, int y) {
        HashSet<String> boys = new HashSet<>();
        while (boys.size() != x) {
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boys.add(familyNameList.getFirst() + boyNameList.getFirst());
        }

        HashSet<String> girls = new HashSet<>();
        while (girls.size() != y) {
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girls.add(familyNameList.getFirst() + girlNameList.getFirst());
        }

        Random r = new Random();
        ArrayList<String> list = new ArrayList<>();
        for (String boy : boys) {
            int i = r.nextInt(10, 20);
            list.add(boy + "-男-" + i);
        }

        for (String girl : girls) {
            int i = r.nextInt(10, 20);
            list.add(girl + "-女-" + i);
        }
        return list;
    }

    private static ArrayList<String> getData(String familyName1, String s, int idx) {
        ArrayList<String> list = new ArrayList<>();
        Pattern compile = Pattern.compile(s);
        Matcher matcher = compile.matcher(familyName1);
        while (matcher.find()) {
            String name = matcher.group(idx);
            list.add(name);
        }
        return list;
    }


    public static String WebCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        //连接上网络
        URLConnection urlConnection = url.openConnection();
        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        return sb.toString();
    }
}
