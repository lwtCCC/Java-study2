package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class TestDemo4_1 {
    public static void main(String[] args) throws IOException {
        /*
        *
        *
        * 接受文件，给出反馈
        * */

        ServerSocket serverSocket = new ServerSocket(10086);
        Socket ss = serverSocket.accept();

        InputStream is = ss.getInputStream();
        BufferedInputStream bis = new BufferedInputStream(is);
        String name = UUID.randomUUID().toString().replace("-","");

        FileOutputStream fos = new FileOutputStream("src/main/java/InetAddressDemo/TestDemo/"+name+".png");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);

        }
        bos.flush();
        bos.close();

        OutputStream os = ss.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
        bw.write("文件已收到");
        bw.flush();
        bw.close();

        serverSocket.close();
    }
}
