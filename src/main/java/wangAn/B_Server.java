package wangAn;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.*;
import java.util.Base64;

public class B_Server{

    public static byte[] rsaDecrypt(byte[] data, PrivateKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] aesDecrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] sha256(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data);
    }

    public static boolean verify(byte[] data, byte[] signData, PublicKey publicKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(signData);
    }

    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPairB = kpg.generateKeyPair();

        PrivateKey B_pri = keyPairB.getPrivate();
        PublicKey B_pub = keyPairB.getPublic();

        System.out.println("B端公钥："
                + Base64.getEncoder().encodeToString(B_pub.getEncoded()));

        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject(B_pub);
        oos.flush();

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

        byte[] cipherText = (byte[]) ois.readObject();
        byte[] encryptedSessionKey = (byte[]) ois.readObject();
        byte[] signature = (byte[]) ois.readObject();
        PublicKey A_pub = (PublicKey) ois.readObject();

        System.out.println("接收数据大小：" + cipherText.length);

        byte[] sessionKeyBytes = rsaDecrypt(encryptedSessionKey, B_pri);
        SecretKey sessionKey = new SecretKeySpec(sessionKeyBytes, "AES");

        byte[] fileData = aesDecrypt(cipherText, sessionKey);

        System.out.println("解密后文件大小：" + fileData.length);

        byte[] hash = sha256(fileData);

        System.out.println("B端文件Hash："
                + Base64.getEncoder().encodeToString(hash));

        boolean ok = verify(hash, signature, A_pub);

        System.out.println("签名验证结果：" + ok);

        if (ok) {
            FileOutputStream fos = new FileOutputStream("received.txt");
            fos.write(fileData);
            fos.close();

            System.out.println("✔ 文件保存成功");
        } else {
            System.out.println("✘ 文件验证失败");
        }

        ois.close();
        oos.close();
        socket.close();
        serverSocket.close();
    }
}
