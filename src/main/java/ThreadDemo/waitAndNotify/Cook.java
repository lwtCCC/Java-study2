package ThreadDemo.waitAndNotify;

public class Cook extends Thread {
    /*
    *
    * 生产者
    * */

    @Override
    public void run() {
        while (true) {
            synchronized (Desk.lock) {
                if(Desk.max==0){
                    System.out.println("不做了，他已经吃饱了 ");
                    break;
                }else{
                    if(Desk.foodFlag!=0){
                        try {
                            System.out.println("吃完在喊我");
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else{
                        System.out.println("做好了，快来吃");
                        Desk.foodFlag++;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
