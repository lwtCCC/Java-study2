package InetAddressDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo1 {
    public static void main(String[] args) throws UnknownHostException {
        /*
        *
        * 网络编程
        *   1.获取InetAddress对象
        *   2.获取IP地址的主机名
        *   3.返回文本显示中的IP字符串
        * */

        //创建InetAddress对象
        InetAddress ia = InetAddress.getByName("张庆昇");
        System.out.println(ia);

        String hostName = ia.getHostName();//获取主机的名字
        System.out.println(hostName);

        String hostAddress = ia.getHostAddress();//获取主机的IP
        System.out.println(hostAddress);

    }
}
