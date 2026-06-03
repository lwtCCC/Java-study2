package ThreadDemo.waitAndNotify;

public class Test {
    public static void main(String[] args) {
        /*
        *
        *
        * 生产者和消费者的测试
        *
        *  代码遇到wait不会退出循环，而是卡在那，等对方释放锁再执行完下面的代码，再去抢
        * 因此会看见自己释放锁自己再次运行，然后才轮到别人抢到锁
        * */

        Dinner dinner = new Dinner();
        Cook cook = new Cook();
        dinner.start();
        cook.start();
    }
}
