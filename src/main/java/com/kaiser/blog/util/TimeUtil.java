package com.kaiser.blog.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName TimeUtil
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/2/1 19:47
 * @Version 1.0
 **/
public class TimeUtil {
    public static String getNowDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
