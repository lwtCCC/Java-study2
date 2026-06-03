package InetAddressDemo.TestDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class TestDemo6_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * 接受文件，给出反馈,多线程实现，线程池实现
        * */

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                6,
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        ServerSocket serverSocket = new ServerSocket(10086);
        while (true) {
            Socket ss = serverSocket.accept();

            threadPoolExecutor.submit(new MyThread(ss));
        }

    }
}
