package InetAddressDemo.TestDemo;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TestDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * TCP多发多收,客户端多次发送
        * */
        Socket socket = new Socket("127.0.0.1",10086);
        OutputStream os = socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            os.write(s.getBytes());
            os.flush();
            if("886".equals(s)){
                break;
            }
        }
        os.close();
        socket.close();

    }
}
