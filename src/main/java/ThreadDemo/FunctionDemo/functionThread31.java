package ThreadDemo.FunctionDemo;

public class functionThread31 extends Thread {
    /*
    *
    *  守护线程
    * */

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(getName() + "@"+i);
        }
    }
}
