package ThreadDemo.FunctionDemo;

public class functionThread32 extends Thread {
    @Override
    public void run() {

        for (int i = 0; i <= 100; i++) {
            System.out.println(getName() + "@"+i);

        }
    }
}
