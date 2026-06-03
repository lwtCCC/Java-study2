package ExceptionDemo.TestDemo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.nextLine();
        girl.setName(name);
        System.out.println("请输入年龄");
        try {
            String age = sc.nextLine();
            girl.setAge(Integer.parseInt(age));
        } catch (NameFormatException e) {
            e.printStackTrace();
        } catch (AgeFormatException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        System.out.println(girl);
    }
}
