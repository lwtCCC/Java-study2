package ThreadDemo.TestDemo1;

public class MyThread3 implements Runnable{
    /*
    *
    * 同步方法实现
    * */

    int ticket = 0;

    @Override
    public void run() {
        while (true){
            if (extracted()) break;
        }
    }

    private synchronized boolean extracted() {
        if(ticket< 100){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ticket++;
            System.out.println(Thread.currentThread().getName() + "正在卖第" + ticket + "张票");
        }else{
            return true;
        }
        return false;
    }
}
