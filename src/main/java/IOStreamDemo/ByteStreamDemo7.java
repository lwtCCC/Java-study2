package IOStreamDemo;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class ByteStreamDemo7 {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /*
        * 编码
        * 解码
        * */

        //编码
        String str = "AAA季非雪";
        byte[] bytes = str.getBytes(); //默认为utf-8
        System.out.println(Arrays.toString(bytes));

        byte[] bytes1 = str.getBytes("GBK"); //GBK编码方式
        System.out.println(Arrays.toString(bytes1));

        //对默认编码方式的  解码
        String s = new String(bytes);//默认解码方式
        System.out.println("默认编码的默认解码："+s);
        String s1 = new String(bytes, "GBK");//GBK解码，因为和编码方式不同，所以会出现乱码
        System.out.println("默认编码的非默认解码："+s1);

        //对特定方式的解码
        String s2 = new String(bytes1, "GBK");
        System.out.println("指定编码的指定解码："+s2);
    }
}
