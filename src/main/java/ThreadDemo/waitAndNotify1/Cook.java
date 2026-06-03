package ThreadDemo.waitAndNotify1;

import java.util.concurrent.ArrayBlockingQueue;

public class Cook extends Thread {
    ArrayBlockingQueue<String> abq;

    public Cook(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                abq.put("面条");
                System.out.println("厨师放了一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
