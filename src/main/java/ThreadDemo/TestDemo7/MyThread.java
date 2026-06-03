package ThreadDemo.TestDemo7;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread {
    static ArrayList<Integer> src;

    public MyThread(ArrayList<Integer> src) {
        this.src = src;
    }

    ArrayList<Integer> list = new ArrayList<>();
    private static final Object lock = new Object();
    int i = 0;
    int total;

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                   if(src.size()==0){
                       break;
                   }else{
                       Collections.shuffle(src);
                       this.list.add((i=src.removeFirst()));
                       total+=i;
                   }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("在本次抽奖中"+getName()+"产生了"+list.size()+"个奖项"+"\n"+
                list+"最大值为"+Collections.max(list)+"总计为"+this.total);
    }
}
