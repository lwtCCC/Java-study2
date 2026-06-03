package ThreadDemo;

import java.util.concurrent.Callable;

public class MyThread3 implements Callable<String> {

    /*
    *
    * 多线程的第三种实现方式
    * 与前面两者不同，他有返回值
    * */

    @Override
    public String call() throws Exception {
        return "季非雪";
    }
}
