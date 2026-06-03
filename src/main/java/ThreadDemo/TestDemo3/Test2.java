package ThreadDemo.TestDemo3;

public class Test2 {
    public static void main(String[] args) {
        MyThread2 mt = new MyThread2();
        Thread t1 = new Thread(mt,"111");
        Thread t2 = new Thread(mt,"222");

        t1.start();
        t2.start();
    }
}
