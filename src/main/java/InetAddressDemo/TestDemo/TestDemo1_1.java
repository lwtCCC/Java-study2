package InetAddressDemo.TestDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TestDemo1_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * TCP多发多收，服务器多次接受
        * */

        ServerSocket serverSocket = new ServerSocket(10086);
        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);
        int i;
        while((i=isr.read())!=-1){
            System.out.print((char)i);
        }
        serverSocket.close();
    }
}
