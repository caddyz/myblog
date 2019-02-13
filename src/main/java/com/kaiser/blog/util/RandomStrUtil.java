package com.kaiser.blog.util;

import java.util.UUID;

/**
 * @ClassName RandomStrUtil
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/2/1 20:03
 * @Version 1.0
 **/
public class RandomStrUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
