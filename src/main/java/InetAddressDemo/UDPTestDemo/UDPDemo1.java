package InetAddressDemo.UDPTestDemo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        * 发送方
        * */

        DatagramSocket ds = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        int port = 10086;
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        while (true) {
            System.out.println("请输入消息");
            String s = sc.nextLine();

            byte[] buf = s.getBytes();

            DatagramPacket dp = new DatagramPacket(buf, buf.length,ip,port);
            ds.send(dp);
            if ("886".equals(s)) {
                break;
            }
        }

        ds.close();
    }
}
