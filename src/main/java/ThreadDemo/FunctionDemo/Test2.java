package ThreadDemo.FunctionDemo;

public class Test2 {
    public static void main(String[] args) {
        /*
        *
        * 测试线程的优先级
        * 默认优先级5
        * 优先级越高抢占的概率越高
        * 获取线程的优先级
        * */
        functionThread2 ft1 = new functionThread2();
        functionThread2 ft2 = new functionThread2();
        ft1.setPriority(10);
        ft2.setPriority(6);
        ft1.start();
        ft2.start();
        System.out.println(ft1.getPriority());
        System.out.println(ft2.getPriority());
        System.out.println(Thread.currentThread().getPriority());
    }
}
