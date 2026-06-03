package InetAddressDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class InetAddressDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * UDP接收数据
        * */

        //接口要和发送方指定端口一样
        DatagramSocket ds = new DatagramSocket(10086);

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ds.receive(dp);

        byte[] data = dp.getData();
        int len = dp.getLength();

        int port = dp.getPort();

        InetAddress inetAddress = dp.getAddress();
        System.out.println("IP Port: "+port);
        System.out.println("IP address : " + inetAddress);
        System.out.println("发送数据为: "+new String(data, 0, len));

    }
}
