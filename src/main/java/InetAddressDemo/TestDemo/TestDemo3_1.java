package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestDemo3_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * 接受文件，给出反馈
        * */

        ServerSocket serverSocket = new ServerSocket(10000);
        Socket ss = serverSocket.accept();

        InputStream is = ss.getInputStream();

        FileOutputStream fos = new FileOutputStream("src/main/java/InetAddressDemo/TestDemo/1_1.png");

        int len;
        byte[] b = new byte[1024];
        while ((len = is.read(b)) != -1) {
            fos.write(b,0,len);
            fos.flush();
        }
        fos.close();

        OutputStream os = ss.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write("文件已收到");
        osw.flush();
        osw.close();

        serverSocket.close();
    }
}
