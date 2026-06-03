package InetAddressDemo.UDPTestDemo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * UDP接收方
        * */
        DatagramSocket ds = new DatagramSocket(10086);
        while(true){

            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);

            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            int port = dp.getPort();
            InetAddress address = dp.getAddress();
            System.out.println("address = " + address);
            System.out.println("port = " + port);
            System.out.println("data = " + new String(data,0,len));

            if ("886".equals(new String(data,0,len))) {
                break;
            }
        }
    }
}
