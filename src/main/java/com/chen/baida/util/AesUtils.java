package com.chen.baida.util;

import com.chen.baida.exception.ChenRuntimeException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * AES加解密工具
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
public class AesUtils {

    private static final String ALGORITHM = "AES";

    private AesUtils(){
        //empty
    }

    /**
     * Encrypts the given plain text
     *
     * @param key       key
     * @param plainText The plain text to encrypt
     */
    public static byte[] encrypt(byte[] key, byte[] plainText) {
        if(key==null || key.length==0){
            throw new ChenRuntimeException("空的参数 key");
        }

        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return cipher.doFinal(plainText);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new ChenRuntimeException("加密发生错误",e);
        }
    }

    /**
     * Decrypts the given byte array
     *
     * @param cipherText The data to decrypt
     */
    public static byte[] decrypt(byte[] key, byte[] cipherText) {
        if(key==null || key.length==0){
            throw new ChenRuntimeException("空的参数 key");
        }
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return cipher.doFinal(cipherText);
        } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | BadPaddingException | IllegalBlockSizeException e) {
            throw new ChenRuntimeException("解密发生错误",e);
        }
    }

}
