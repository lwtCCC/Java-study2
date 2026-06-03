package ThreadDemo.TestDemo8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyThread implements Callable<Integer> {

    /*
    *
    *
    * 多线程之间的交互
    * */
    ArrayList<Integer> list;
    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Integer call() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int total = 0;
        int i;
        while(true){
            synchronized (this){
                if (list.size()==0){
                    break;
                }else{
                    Collections.shuffle(list);
                    arrayList.add((i=list.removeFirst()));
                    total+=i;
                }
            }
            Thread.sleep(100);
        }
        System.out.println("在本次抽奖中"+Thread.currentThread().getName()+"产生了"+arrayList.size()+"个奖项"+"\n"+
                arrayList+"最大值为"+Collections.max(arrayList)+"总计为"+total);

        return Collections.max(arrayList);
    }
}
