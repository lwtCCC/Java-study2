package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class TestDemo5_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * 接受文件，给出反馈,多线程实现
        * */

        ServerSocket serverSocket = new ServerSocket(10086);
        while (true) {
            Socket ss = serverSocket.accept();

            new Thread(new MyThread(ss)).start();
        }

    }
}
