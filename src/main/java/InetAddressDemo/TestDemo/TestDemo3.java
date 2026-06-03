package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 上传文件，接受反馈
        * */
        Socket socket = new Socket("127.0.0.1",10086);
        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("src/main/java/InetAddressDemo/TestDemo/1.png");

        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes))!=-1){
            os.write(bytes,0,len);
            os.flush();
        }
        fis.close();

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int i;
        while((i=isr.read())!=-1){
            System.out.print((char)i);
        }

        socket.close();

    }
}
