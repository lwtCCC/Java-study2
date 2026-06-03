package ThreadDemo.TestDemo4;

public class Test {
    public static void main(String[] args) {
        /*
        *
        * 两个线程输出1-100之间的奇数
        * */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}
