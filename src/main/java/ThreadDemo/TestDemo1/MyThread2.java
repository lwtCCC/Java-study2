package ThreadDemo.TestDemo1;

public class MyThread2 extends Thread {

    /*
    *
    * 同步代码块
    * */
    static int ticket = 0;
    static final Object lock = new Object();


    @Override
    public void run() {
        while (true){
            synchronized (lock){
                if(ticket< 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }else{
                    break;
                }
            }
        }
    }
}
