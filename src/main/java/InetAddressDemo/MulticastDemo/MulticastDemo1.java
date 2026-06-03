package InetAddressDemo.MulticastDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastDemo1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 实现组播
        * */

        MulticastSocket ms = new MulticastSocket();

        String s = "123";
        byte[] buf = s.getBytes();
        InetAddress ip = InetAddress.getByName("224.0.0.3");//这里需要指定组播地址
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(buf, buf.length,ip,port);
        ms.send(dp);
        ms.close();
    }
}
