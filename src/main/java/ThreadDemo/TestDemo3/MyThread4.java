package ThreadDemo.TestDemo3;

public class MyThread4 implements Runnable {
    int i = 100;

    @Override
    public void run() {
        while (true) {
            if (extracted()) break;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized boolean extracted() {
        if (i < 10) {
            return true;
        }else{
            i--;
            System.out.println(Thread.currentThread().getName()+"还剩"+i);
        }
        return false;
    }
}
