package ThreadDemo;

public class MyThread extends Thread {
    /*
    *
    * 实现多线程的方案1
    * 继承实现
    * */

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"第"+i+"次运行");
        }
    }
}
