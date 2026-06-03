package ThreadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test5 {
    public static void main(String[] args) {
        /*
        *
        *
        *自定义线程池
        * 参数：
        * 1.主线程的数量
        * 2.最大线程的数量
        * 3.线程生存的时间
        * 4.时间的单位
        * 5.任务队列
        * 6.线程工厂
        * 7.阻塞策略
        *
        * 什么时候创建额外线程，当等待队列填满了再创建
        * */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,//主线程的数量
                6,//最大线程的数量
                60,//线程生存的时间
                TimeUnit.SECONDS,//时间的单位
                new ArrayBlockingQueue<>(4),//任务队列
                Executors.defaultThreadFactory(),//线程工厂
                new ThreadPoolExecutor.AbortPolicy()//阻塞策略
        );

        threadPoolExecutor.submit(new MyThread5());
        threadPoolExecutor.submit(new MyThread5());
        threadPoolExecutor.submit(new MyThread5());
        threadPoolExecutor.submit(new MyThread5());

        threadPoolExecutor.shutdown();
    }
}
