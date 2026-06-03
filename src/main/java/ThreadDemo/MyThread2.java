package ThreadDemo;

public class MyThread2 implements Runnable {

    /*
    *
    * 多线程实现
    * 接口实现
    * */

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"第"+i+"次运行");
        }
    }
}
