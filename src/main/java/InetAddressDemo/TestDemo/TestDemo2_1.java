package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestDemo2_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * TCP多发多收，服务器多次接受并给出反馈
        * */

        ServerSocket serverSocket = new ServerSocket(10086);

        Socket accept = serverSocket.accept();

        InputStream inputStream = accept.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);

        OutputStream outputStream = accept.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(outputStream);

        String s = "我收到了你的消息";
        byte[] bytes = s.getBytes();
        int i;
        while((i=isr.read())!=-1){
            System.out.print((char)i);
        }

        osw.write(s);
        osw.flush();

        accept.close();
        serverSocket.close();
    }
}
