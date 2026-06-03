package ThreadDemo;

public class Test6 {
    public static void main(String[] args) {
        /*
        *
        * 获取电脑的可用的最大线程数
        * */
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

    }
}
