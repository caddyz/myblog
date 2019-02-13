package com.kaiser.blog.util;

import com.kaiser.blog.constant.Constant;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName Encryption
 * @Description TODO 加密类
 * @Author Kaiser
 * @Date 2019/2/1 19:10
 * @Version 1.0
 **/
public class Encryption {
    public static String md5(String pwd){
        byte[] secretBytes = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(Constant.SECRET_TYPE);
            instance.update(pwd.getBytes());
            secretBytes = instance.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("输入有误！没有找到输入的值");
        }
        StringBuilder newEncryption = new StringBuilder();
        StringBuilder EncryptionStr = new StringBuilder(new BigInteger(1, secretBytes).toString());
        if(EncryptionStr.length() < 32){
            for (int i = 0; i < EncryptionStr.length(); i++) {
                newEncryption = EncryptionStr.insert(0,"0");
            }
        }else{
            newEncryption = EncryptionStr;
        }
        return newEncryption.toString();
    }
}
