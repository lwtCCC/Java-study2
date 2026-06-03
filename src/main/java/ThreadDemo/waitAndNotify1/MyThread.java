package ThreadDemo.waitAndNotify1;

import java.util.concurrent.ArrayBlockingQueue;

public class MyThread {


    public static void main(String[] args) {

        /*
         *
         * 阻塞队列
         * 生产者和消费者使用同一个阻塞队列
         * */

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(abq);
        Dinner dinner = new Dinner(abq);
        cook.start();
        dinner.start();
    }
}
