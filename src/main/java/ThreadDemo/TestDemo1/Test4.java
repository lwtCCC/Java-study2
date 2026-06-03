package ThreadDemo.TestDemo1;

public class Test4 {
    public static void main(String[] args) {
        /*
        *
        *
        * 使用lock
        * */

        MyThread4 mt1 = new MyThread4();
        MyThread4 mt2 = new MyThread4();
        MyThread4 mt3 = new MyThread4();

        mt1.setName("窗口1");
        mt2.setName("窗口2");
        mt3.setName("窗口3");

        mt1.start();
        mt2.start();
        mt3.start();
    }
}
