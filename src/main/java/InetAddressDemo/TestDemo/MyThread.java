package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyThread implements Runnable{

    Socket socket;

    public MyThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            InputStream is = socket.getInputStream();
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

            OutputStream os = socket.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            bw.write("文件已收到");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
