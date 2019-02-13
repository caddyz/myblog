package com.kaiser.blog.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


/**
 * @ClassName JSON
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/30 11:47
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {
    private String keyWord;
    private String msg;
    private Object data;
    private boolean succ;
}
