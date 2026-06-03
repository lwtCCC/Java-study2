package ThreadDemo.FunctionDemo;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        * 线程常用方法
        *   1.获取名字
        *   2.获取当前线程
        *   3.睡眠
        * */
        functionThread ft1 = new functionThread("花花花");
        functionThread ft2 = new functionThread("卡卡卡");

        ft1.start();
        ft2.start();

        /*Thread thread = Thread.currentThread();
        System.out.println(thread.getName());//当前线程main*/

        System.out.println(111111111);
        Thread.sleep(5000);//  线程睡眠5秒
        System.out.println(222222222);
    }
}
