package ThreadDemo.TestDemo5;

import java.util.Random;

public class MyThread extends Thread {
    static double i=100;
    static final Object lock=new Object();

    private Random r=new Random();
    private double min = 0.01;
    static int count=3;
    @Override
    public void run() {
            synchronized (lock) {

                if (count==0) {
                    System.out.println(getName()+"没抢到");
                }else{
                    double x = 0;
                    if(count==1){
                        x = i;
                    }else{
                        i = i - (count-1)*min;
                        x = r.nextDouble(min,i);
                    }
                    i -= x;
                    count--;
                    System.out.println(getName()+"抢到"+x);
                }
            }
    }
}
