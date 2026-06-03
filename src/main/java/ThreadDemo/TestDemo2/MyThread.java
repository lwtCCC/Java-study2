package ThreadDemo.TestDemo2;

public class MyThread extends Thread {

    private static int ticket = 1000;
    private static final Object lock = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (ticket > 0) {
                    ticket--;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(getName()+"卖出第"+(1000 - ticket)+"票");
                    System.out.println("还剩"+ticket+"张票");
                }else{
                    break;
                }
            }
        }
    }

}
