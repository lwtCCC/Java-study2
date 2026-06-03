package ThreadDemo.TestDemo6;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    static final Object lock = new Object();
    static ArrayList<Integer> list;
    public MyThread(ArrayList<Integer> list){
        MyThread.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (lock){
                if(list.size()==0){
                    break;
                }else{
                    Collections.shuffle(list);
                    Integer remove = list.removeFirst();
                    System.out.println(getName()+"又产生了一个"+remove+"元大奖");
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
