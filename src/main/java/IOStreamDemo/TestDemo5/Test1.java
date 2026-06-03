package IOStreamDemo.TestDemo5;

import java.io.*;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) throws IOException {

        /*
         * 账号密码读取
         * */

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/main/java/IOStreamDemo/TestDemo5/gg.txt"));
        byte[] bytes = new byte[1024];
        String s = null;
        int b;
        while ((b = bis.read(bytes)) != -1) {
            s = new String(bytes, 0, b);
        }

        String[] nameAndPassword = s.split("&");

        String nameStr = nameAndPassword[0];
        String passwordStr = nameAndPassword[1];

        String name =  nameStr.split("=")[1];
        String password = passwordStr.split("=")[1];

        Scanner sc = new Scanner(System.in);
        System.out.println("username:");
        String s1 = sc.nextLine();
        System.out.println("password:");
        String s2 = sc.nextLine();
        if(s1.equals(name) && s2.equals(password)){
            System.out.println("登录成功");
        }else{
            System.out.println("用户名或密码错误");
        }
    }
}
