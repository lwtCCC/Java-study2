package ThreadDemo.FunctionDemo;

public class functionThread4 extends Thread {
    /*
    *
    * 礼让线程
    * */

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(getName() + "@" + i);
            Thread.yield();//出让CPU的执行权
        }
    }

}
