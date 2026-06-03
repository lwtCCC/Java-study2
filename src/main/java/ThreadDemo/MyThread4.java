package ThreadDemo;

public class MyThread4 implements Runnable{
    /*
    *
    *  测试线程池
    * */
    @Override
    public void run() {
        for(int i=0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"---"+i);
        }
    }
}
