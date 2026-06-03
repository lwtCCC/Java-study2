package ThreadDemo.TestDemo8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        *
        *  实现多线程的交互
        * */
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,10,5,20,50,100,200,500,800,2,80,300,700);

        MyThread myThread = new MyThread(list);
        FutureTask<Integer> task1 = new FutureTask<>(myThread);
        FutureTask<Integer> task2 = new FutureTask<>(myThread);
        Thread t1 = new Thread(task1, "抽奖箱1");
        Thread t2 = new Thread(task2, "抽奖箱2");

        t1.start();
        t2.start();

        if(task1.get() > task2.get()){
            System.out.println("抽奖箱1获得了最大值");
        }else{
            System.out.println("抽奖箱2获得了最大值");
        }

    }
}
