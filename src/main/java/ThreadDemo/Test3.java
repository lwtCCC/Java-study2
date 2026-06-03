package ThreadDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread3 mt = new MyThread3();
        FutureTask<String> s = new FutureTask<>(mt);
        Thread thread = new Thread(s);
        thread.start();
        System.out.println(s.get());//获取线程的结果

    }
}
