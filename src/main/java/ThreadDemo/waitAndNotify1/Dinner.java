package ThreadDemo.waitAndNotify1;

import java.util.concurrent.ArrayBlockingQueue;

public class Dinner extends Thread {
    ArrayBlockingQueue<String> abq;

    public Dinner(ArrayBlockingQueue<String> abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String take = abq.take();
                System.out.println(take);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
