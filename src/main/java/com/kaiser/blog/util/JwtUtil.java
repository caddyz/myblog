package com.kaiser.blog.util;

import com.kaiser.blog.constant.Constant;
import io.jsonwebtoken.*;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class JwtUtil {
    //字符串生成加密key
    public static SecretKey generalKey(){
        String key = Constant.JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(key);
        return new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
    }
    //生成jwt
    public static String createJwt(String id,String subject,long ttlMills) throws Exception{
        //指定签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //jwt生成时间
        long nowMills = System.currentTimeMillis();
        Date date = new Date(nowMills);
        //playload私有声明
        Map<String,Object> claims = new HashMap<>();
        claims.put("uid",RandomStrUtil.getUUID());
        claims.put("user","register");
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(date)
                .signWith(signatureAlgorithm,key);
        if (ttlMills >= 0){
            long expMills = nowMills + ttlMills;
            Date exp = new Date(expMills);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /*public static void main(String[] args) throws Exception {
        String jwt = JwtUtil.createJwt(RandomStrUtil.getUUID(), "{id:100,name:xiaohong}", 60000);
        System.out.println("token:"+jwt);
        System.out.println("--------------分割线-------------------------");
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims.getId());
        System.out.println(claims.getSubject());
        System.out.println(claims.getIssuedAt());
        System.out.println(claims.getAudience());
        System.out.println(claims.get("uid",String.class));
        System.out.println(claims.get("user",String.class));
    }*/
}
