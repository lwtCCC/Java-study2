package ThreadDemo.TestDemo2;

public class Test {
    public static void main(String[] args) {
        /*
        *
        *  售票的多线程实现
        * */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("售票口1");
        t2.setName("售票口2");
        t1.start();
        t2.start();
    }
}
