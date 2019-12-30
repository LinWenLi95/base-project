package com.lwl.project.admin.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * AES加解密工具
 * 加密流程：明文->AES加密->Base64编码->密文
 * 加密流程：密文->Base64解码->AES解密->明文
 */
public class AesEncryptUtils {

    private static final String KEY = "d7b85f6e214abcda";
    private static final String ALGORITHMSTR = "AES/ECB/PKCS5Padding";


    /**
     * AES加密
     * @param content 明文内容
     * @param encryptKey 加密密钥
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        return base64Encode(aesEncryptToBytes(content, encryptKey));
    }

    /**
     * AES解密
     * @param encryptStr 加密内容
     * @param decryptKey 解密密钥
     */
    public static String aesDecrypt(String encryptStr, String decryptKey) throws Exception {
        return aesDecryptByBytes(base64Decode(encryptStr), decryptKey);
    }

    /**
     * AES加密为Byte数组（加密步骤1）
     * @param content 明文内容
     * @param encryptKey 加密密钥
     * @return
     * @throws Exception
     */
    public static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));
        return cipher.doFinal(content.getBytes("utf-8"));
    }

    /**
     * Base64编码（加密步骤2）
     * @param bytes 要编码的内容
     * @return
     */
    public static String base64Encode(byte[] bytes) {
        return Base64.encodeBase64String(bytes);
    }

    /**
     * Base64解码（解密步骤1）
     * @param base64Code Base64编码内容
     */
    public static byte[] base64Decode(String base64Code) throws Exception {
        return Base64.decodeBase64(base64Code);
    }

    /**
     * AES解密（解密步骤2）
     * @param encryptBytes 加密内容
     * @param decryptKey 解密密钥
     */
    public static String aesDecryptByBytes(byte[] encryptBytes, String decryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
        byte[] decryptBytes = cipher.doFinal(encryptBytes);
        return new String(decryptBytes);
    }

    /**
     * 使用例子
     */
    public void demo() throws Exception {
        String content = "你好";
        System.out.println("加密前：" + content);
        String encrypt = aesEncrypt(content, KEY);
        System.out.println("加密后：" + encrypt);
        String decrypt = aesDecrypt(encrypt, KEY);
        System.out.println("解密后：" + decrypt);
    }

}
