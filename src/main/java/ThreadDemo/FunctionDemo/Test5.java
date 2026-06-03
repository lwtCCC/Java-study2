package ThreadDemo.FunctionDemo;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        /*
        * 插入线程
        *把调用者线程插入到当前线程之前
        * 当调用者结束才运行当前线程
        *
        * */

        functionThread5 ft1 = new functionThread5();
        ft1.setName("秋月华");
        ft1.start();

        ft1.join();//把调用者线程插入到当前线程之前

        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "@" + i);
        }
    }
}
