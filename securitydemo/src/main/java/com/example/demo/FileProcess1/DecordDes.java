package com.example.demo.FileProcess1;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.Arrays;

/**
 * @author ThomasCui
 * @Descrption
 * @create 2018/9/20
 */
public class DecordDes {
    // 算法名称
    final String KEY_ALGORITHM = "AES";

    // 加解密算法/模式/填充方式
    final String algorithmStr = "AES/CBC/PKCS7Padding";
    //
    private Key key;
    private Cipher cipher;

    public void init(byte[] keyBytes) {

        // 如果密钥不足16位，那么就补足. 这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(algorithmStr);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public byte[] decrypt(String encryptedDataStr, String keyBytesStr, String ivStr) {
        byte[] encryptedText = null;
        byte[] encryptedData = null;
        byte[] sessionkey = null;
        byte[] iv = null;

        try {
            sessionkey = Base64.decodeBase64(keyBytesStr);
            encryptedData = Base64.decodeBase64(encryptedDataStr);
            iv = Base64.decodeBase64(ivStr);

            init(sessionkey);

            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return encryptedText;
    }


    public static void main(String[] args) throws IOException {

        DecordDes d = new DecordDes();
        String content = "CNtSo3kCTxYoaxdhxzmVN/CvIJK41+1DOTZcrXUVMd9+5Z8jTDvbn6kExXRzH+EqWD6oyXwxUzYsW5nyZ7hGAx4pqYylJUzshx+R9DrpQ7HAb5ScH1e0zk//UAiD11W19uFo2/nYyx5ug99jCj6YOgicpfNHSatqkLVRryQlDEzNyaEuo/84uHIpxwC7t8yqmuwUtW2qedtJxWmYWOC1ZQ==";
        String key = "9QJPlP2TyuDFH1A73pnGqg==";
        String iv = "SABdIDCax6u7H0f6OILGzw==";
        byte[] result = d.decrypt(content, key, iv);
        System.out.println(new String(result, "UTF-8"));
        System.out.println(key.substring(0, key.length() - 10) + "  " + key.substring(key.length() - 10, key.length() - 1));

        System.out.println("========================");

        String old = "x1EGMzMXNiMIrt/xRwEkRQlv+1gqRonzaBvRPJQNTWtPCwxRps6516ePRK4EhHDuZ9yIa5zRuaErrdhFIUyMfw==";


    }
}
