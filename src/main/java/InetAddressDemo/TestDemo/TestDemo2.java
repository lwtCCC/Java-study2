package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * TCP多发多收,客户端多次发送
        * */
        Socket socket = new Socket("127.0.0.1",10086);

        OutputStream os = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);

        InputStream inputStream = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(inputStream);


        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        osw.write(s);
        osw.flush();

        socket.shutdownOutput();

        int i;
        while ((i = isr.read()) != -1) {
            System.out.print((char) i);
        }

        socket.close();
    }
}
