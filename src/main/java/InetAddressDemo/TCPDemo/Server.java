package InetAddressDemo.TCPDemo;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //TCP协议，接收数据
        ServerSocket ss = new ServerSocket(10086);
        Socket socket = ss.accept();

        InputStream in = socket.getInputStream();
        int i;
        byte[] buf = new byte[3];
        while ((i = in.read(buf)) != -1) {
            System.out.print(new String(buf,0,i));
        }

    }
}
