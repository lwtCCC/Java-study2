package ThreadDemo.TestDemo3;

public class Test3 {
    public static void main(String[] args) {
        MyThread3 t1 = new MyThread3();
        MyThread3 t2 = new MyThread3();
        t1.setName("111");
        t2.setName("222");
        t1.start();
        t2.start();
    }
}
