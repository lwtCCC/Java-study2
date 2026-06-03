package ThreadDemo;

public class Test2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();

        Thread t1 = new Thread(mt,"线程1");
        Thread t2 = new Thread(mt,"线程2");
        t1.start();
        t2.start();

    }
}
