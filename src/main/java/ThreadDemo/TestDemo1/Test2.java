package ThreadDemo.TestDemo1;

public class Test2 {
    public static void main(String[] args) {
        /*
        *
        *  使用同步代码块保护线程安全
        * */

        MyThread2 mt1 = new MyThread2();
        MyThread2 mt2 = new MyThread2();
        MyThread2 mt3 = new MyThread2();

        mt1.setName("窗口1");
        mt2.setName("窗口2");
        mt3.setName("窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
