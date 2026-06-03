package ThreadDemo.waitAndNotify;

public class Dinner extends Thread {

    /*
    *
    * 消费者
    * 1.循环
    * 2.同步代码块
    * 3.数据到了末尾的处理
    * 4.没到末尾的处理
    * */

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if(Desk.max == 0){
                    System.out.println("吃不下了");
                    break;
                }else{
                    if(Desk.foodFlag == 0){
                        try {
                            System.out.println("没饭吃");
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("开吃了，再去做");
                        Desk.foodFlag--;
                        Desk.max--;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
