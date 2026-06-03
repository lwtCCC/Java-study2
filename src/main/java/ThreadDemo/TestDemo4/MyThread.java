package ThreadDemo.TestDemo4;

public class MyThread extends Thread {
    static int i=1;
    static final Object obj=new Object();
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                if(i == 100){
                    break;
                }else{
                    if(i%2==1){
                        System.out.println(getName()+"@"+i);
                    }
                    i++;
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
