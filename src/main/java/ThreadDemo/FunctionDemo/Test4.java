package ThreadDemo.FunctionDemo;

public class Test4 {
    public static void main(String[] args) {
        /*
        *
        * 设置礼让线程
        * 出让CPU 的执行权，但是依旧是抢夺
        * */

        functionThread4 ft1 = new functionThread4();
        functionThread4 ft2 = new functionThread4();

        ft1.setName("季非雪");
        ft2.setName("张明");

        ft1.start();
        ft2.start();
    }
}
