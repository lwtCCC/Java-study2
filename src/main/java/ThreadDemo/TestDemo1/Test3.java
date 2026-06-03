package ThreadDemo.TestDemo1;

public class Test3 {
    public static void main(String[] args) {
        /*
        *
        * 利用同步方法实现多线程安全
        * 方法静态：锁为class文件
        * 非静态：this
        * 比如，如果使用继承方法来实现多线程，就需要创建多个实现对象，那么这些对象就要有一个共享的值，所以用静态，满足资源共享的同时，让锁为class文件
        * 反之亦然
        * */

        MyThread3 mt = new MyThread3();
        Thread t1 = new Thread(mt);
        Thread t2 = new Thread(mt);
        Thread t3 = new Thread(mt);


        t1.setName("Thread1");
        t2.setName("Thread2");
        t3.setName("Thread3");

        t1.start();
        t2.start();
        t3.start();
    }
}
