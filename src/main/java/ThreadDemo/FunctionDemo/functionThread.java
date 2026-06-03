package ThreadDemo.FunctionDemo;

public class functionThread extends Thread {
    /*
     *
     *   测试线程的常用方法
     * */

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName() + "@" + i);
        }
    }

    public functionThread(String name) {
        super(name);
    }

    public functionThread() {
    }
}
