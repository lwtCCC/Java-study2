package ThreadDemo.TestDemo3;

public class MyThread3 extends Thread {
    static int pare = 100;

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

    private static synchronized boolean extracted() {
        if (pare < 10) {
            return true;
        } else {
            pare--;
            System.out.println(Thread.currentThread().getName() + "还剩" + pare);
        }
        return false;
    }
}
