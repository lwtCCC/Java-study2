package ThreadDemo.TestDemo3;

public class Test4 {
    public static void main(String[] args) {

        MyThread4 mt = new MyThread4();
        Thread t1 = new Thread(mt,"111");
        Thread t2 = new Thread(mt,"222");
        t1.start();
        t2.start();
    }
}
