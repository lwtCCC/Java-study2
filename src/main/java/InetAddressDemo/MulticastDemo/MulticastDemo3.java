package InetAddressDemo.MulticastDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastDemo3 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * 加入组播
        * */

        MulticastSocket ms = new MulticastSocket(10086);

        InetAddress ip = InetAddress.getByName("224.0.0.3");
        ms.joinGroup(ip);//加入组播地址

        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        ms.receive(dp);
        byte[] data = dp.getData();
        int len = dp.getLength();
        String s = new String(data,0,len);

        System.out.println(s);
        ms.close();
    }
}
