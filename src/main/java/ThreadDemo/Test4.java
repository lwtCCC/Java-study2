package ThreadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test4 {
    public static void main(String[] args) {

        /*
        *
        * 测试Java工具类提供的线程池
        * 当使用有数量限制的线程池时，会根据任务的数量来增加线程，当线程达到上限时，未完成的任务会去等待
        * */

        //1.创建线程池
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //2.提交任务
        executorService.submit(new MyThread4());
        executorService.submit(new MyThread4());
        executorService.submit(new MyThread4());
        executorService.submit(new MyThread4());

        //3.销毁线程池
        executorService.shutdown();
    }
}
