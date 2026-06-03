package InetAddressDemo.TestDemo;

import java.io.*;
import java.net.Socket;

public class TestDemo6 {
    public static void main(String[] args) throws IOException {
        /*
         *
         * 上传文件，接受反馈, 使用UUID
         * */
        Socket socket = new Socket("127.0.0.1", 10086);

        FileInputStream fis = new FileInputStream("src/main/java/InetAddressDemo/TestDemo/1.png");
        BufferedInputStream bis = new BufferedInputStream(fis);

        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);

        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bos.flush();
        bis.close();

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        socket.close();

    }
}
