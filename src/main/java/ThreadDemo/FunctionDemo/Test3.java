package ThreadDemo.FunctionDemo;

public class Test3 {
    public static void main(String[] args) {
        /*
        *
        * 设置守护线程
        * 要在线程启动前调用
        * 被守护者先结束的话，守护线程也会跟着结束
        * 有可能发生守护线程先结束的情况
        * */

        functionThread31 ft1 = new functionThread31();
        functionThread32 ft2 = new functionThread32();
        ft1.setName("被守护者");
        ft2.setName("守护者");
        ft2.setDaemon(true);
        ft1.setPriority(10);
        ft1.start();
        ft2.start();

    }
}
