package InetAddressDemo;

import java.io.IOException;
import java.net.*;

public class InetAddressDemo2 {
    public static void main(String[] args) throws IOException {
        /*
        *
        * UDP发送数据（发送方）
        * */

        //1.打包数据的打包站点
        //有参：指定一个端口号进行发送
        //无参：随机一个可用的端口号
        DatagramSocket ds = new DatagramSocket();


        //2.打包数据
        String str = "hello world, 罗薇塔";
        byte[] buf = str.getBytes();

        InetAddress ip = InetAddress.getByName("127.0.0.1");

        int port = 10086;

        DatagramPacket dp = new DatagramPacket(buf, buf.length,ip,port);

        //3.打包出去
        ds.send(dp);

        ds.close();

    }
}
