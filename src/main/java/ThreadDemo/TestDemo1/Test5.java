package ThreadDemo.TestDemo1;

public class Test5 {
    public static void main(String[] args) {
        /*
        *
        *
        * 死锁示例
        * */
        MyThread5 t1 = new MyThread5();
        MyThread5 t2 = new MyThread5();

        t1.setName("A");
        t2.setName("B");

        t1.start();
        t2.start();
    }
}
