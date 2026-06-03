package ThreadDemo.TestDemo3;

public class MyThread extends Thread {
    static int pare = 100;
    static final Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (pare < 10) {
                    break;
                }else{
                    pare--;
                    System.out.println(getName()+"还剩"+pare);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
