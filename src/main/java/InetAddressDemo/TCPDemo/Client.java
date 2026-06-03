package InetAddressDemo.TCPDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //TCP协议，发送数据
        Socket socket = new Socket("127.0.0.1",10086);

        OutputStream os = socket.getOutputStream();
        os.write("你好世界".getBytes());
        os.close();
        socket.close();
    }
}
