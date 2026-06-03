package ThreadDemo.TestDemo1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread4 extends Thread {

    /*
    *
    * lock锁
    *  边际条件要注意锁的释放
    * */
    static int ticket = 0;
    static Lock lock = new ReentrantLock();//创建lock实例


    @Override
    public void run() {
        while (true){
            lock.lock();//加锁
            try {
                if(ticket< 100){
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }else{
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();//释放锁
            }
        }
    }
}
