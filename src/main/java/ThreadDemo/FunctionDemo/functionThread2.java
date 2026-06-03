package ThreadDemo.FunctionDemo;

public class functionThread2 extends Thread {
    /*
     *
     * 常用的线程方法
     * 线程的优先级
     * */

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(getName() + "@" + i);
        }
    }
}
