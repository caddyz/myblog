package com.kaiser.blog.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;


/**
 * @ClassName ForeRegister
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/30 17:58
 * @Version 1.0
 **/
@Data
@EqualsAndHashCode
public class ForeRegister implements Serializable {

    private static final long serialVersionUID = 7081961992411001663L;
    private String name;
    private String pass;
    private String checkPass;
    private String email;
    private String phone;
    private String[] address;
}
