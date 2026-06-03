package ThreadDemo.TestDemo3;

public class MyThread2 implements Runnable{
    int i=100;

    @Override
    public void run() {
        while (true){
            synchronized (this){
                if(i<10){
                    break;
                }else{
                    i--;
                    System.out.println(Thread.currentThread().getName()+"还剩"+i);
                }
            }
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
