package wangAn;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.util.Base64;

public class A_Client{

    public static byte[] rsaEncrypt(byte[] data, PublicKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] aesEncrypt(byte[] data, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(data);
    }

    public static byte[] sha256(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data);
    }

    public static byte[] sign(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPairA = kpg.generateKeyPair();

        PublicKey A_pub = keyPairA.getPublic();
        PrivateKey A_pri = keyPairA.getPrivate();

        Socket socket = new Socket("localhost", 9999);

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
        PublicKey B_pub = (PublicKey) ois.readObject();

        System.out.println("A端接收到B公钥："
                + Base64.getEncoder().encodeToString(B_pub.getEncoded()));

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        byte[] fileData = Files.readAllBytes(Paths.get("test.txt"));

        System.out.println("A端文件大小：" + fileData.length);

        byte[] hash = sha256(fileData);
        System.out.println("A端文件Hash："
                + Base64.getEncoder().encodeToString(hash));

        KeyGenerator kg = KeyGenerator.getInstance("AES");
        kg.init(128);
        SecretKey sessionKey = kg.generateKey();

        byte[] cipherText = aesEncrypt(fileData, sessionKey);

        System.out.println("密文(Base64)："
                + Base64.getEncoder().encodeToString(cipherText));

        byte[] encryptedSessionKey = rsaEncrypt(sessionKey.getEncoded(), B_pub);

        System.out.println("加密后的会话密钥(Base64)："
                + Base64.getEncoder().encodeToString(encryptedSessionKey));

        byte[] signature = sign(hash, A_pri);

        System.out.println("数字签名(Base64)："
                + Base64.getEncoder().encodeToString(signature));

        oos.writeObject(cipherText);
        oos.writeObject(encryptedSessionKey);
        oos.writeObject(signature);
        oos.writeObject(A_pub);

        System.out.println("发送数据大小：" + cipherText.length);

        oos.close();
        ois.close();
        socket.close();
    }
}
