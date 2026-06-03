package ThreadDemo.TestDemo3;

public class Test {
    public static void main(String[] args) {
        /*
        *
        * 模拟送礼，当礼物数量小于10 的时候不送
        * */

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.setName("1111");
        t2.setName("2222");

        t1.start();
        t2.start();
    }
}
