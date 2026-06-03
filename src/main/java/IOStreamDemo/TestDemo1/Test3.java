package IOStreamDemo.TestDemo1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) throws IOException {
        /*
         *
         * 对文件内容进行排序（数字）
         * */

        //方法1：直接字符串排序
        /*//读取文件
        FileReader fr = new FileReader("src/main/java/IOStreamDemo/TestDemo1/a.txt");

        StringBuffer sb = new StringBuffer();
        int i;
        while((i = fr.read()) != -1){
            sb.append((char)i);
        }
        String str = sb.toString();
        System.out.println(str);

        //转换
        String[] arrStr = str.split("-");
        Arrays.sort(arrStr);
        System.out.println(Arrays.toString(arrStr));

        //输出
        FileWriter fw = new FileWriter("src/main/java/IOStreamDemo/TestDemo1/a1.txt");

        for (int i1 = 0; i1 < arrStr.length; i1++) {
            if(i1 == arrStr.length-1) fw.write(arrStr[i1] + "");
            else fw.write(arrStr[i1] + "-");
        }

        fr.close();
        fw.close();*/

        //方法2:转换成数字
        /*FileReader fr = new FileReader("src/main/java/IOStreamDemo/TestDemo1/a.txt");

        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = fr.read()) != -1) {
            sb.append((char) i);
        }
        String str = sb.toString();
        System.out.println(str);

        String[] arrStr = str.split("-");
        ArrayList<Integer> list = new ArrayList<>();
        for (String s : arrStr) {
            list.add(Integer.parseInt(s));
        }

        Collections.sort(list);

        FileWriter fw = new FileWriter("src/main/java/IOStreamDemo/TestDemo1/a1.txt");

        for (int i1 = 0; i1 < list.size(); i1++) {
            if (i1 == list.size() - 1) fw.write(list.get(i1) + "");
            else fw.write(list.get(i1) + "-");
        }

        fr.close();
        fw.close();
        */
        
        //方法3：使用流
        FileReader fr = new FileReader("src/main/java/IOStreamDemo/TestDemo1/a.txt");

        StringBuffer sb = new StringBuffer();
        int i;
        while ((i = fr.read()) != -1) {
            sb.append((char) i);
        }
        String str = sb.toString();
        System.out.println(str);

        Integer[] array = Arrays.stream(str.split("-")).
                map(Integer::parseInt).
                sorted().
                toArray(Integer[]::new);
        String string = Arrays.toString(array);

        FileWriter fw = new FileWriter("src/main/java/IOStreamDemo/TestDemo1/a1.txt");
        String s = string.replace(", ", "-");
        System.out.println(s);
        String result = s.substring(1, s.length() - 1);
        System.out.println(result);
        fw.write(result);

        fr.close();
        fw.close();
    }
}
