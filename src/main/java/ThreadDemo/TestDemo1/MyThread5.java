package ThreadDemo.TestDemo1;

public class MyThread5 extends Thread {
    /*
    *
    * 死锁
    *
    * */
    static Object objA = new Object();
    static Object objB = new Object();

    @Override
    public void run() {
        while (true) {
            if(getName().equals("A")){
                synchronized (objA) {
                    System.out.println("A线程拿到A锁，主备去拿B锁");
                    synchronized (objB) {
                        System.out.println("A线程拿到B锁，顺利执行完");
                    }
                }
            }else if(getName().equals("B")){
                synchronized (objB) {
                    System.out.println("B线程拿到B锁，主备去拿A锁");
                    synchronized (objA) {
                        System.out.println("B线程拿到A锁，顺利执行完");
                    }
                }
            }
        }
    }
}
