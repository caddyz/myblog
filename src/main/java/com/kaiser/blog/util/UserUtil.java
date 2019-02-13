package com.kaiser.blog.util;

/**
 * @ClassName UserUtil
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/2/10 12:49
 * @Version 1.0
 **/
public class UserUtil {
    /**
     *
     * @param browserPassword 前端的用户密码
     * @param dataBasePassword 数据库存储的密码
     * @param salt 盐
     * @return boolean
     */
   public static boolean judgeUser(String browserPassword,String dataBasePassword,String salt){
       if(Encryption.md5(browserPassword.concat(salt)).equals(dataBasePassword)){
           return true;
       }
       return false;
   }


}
