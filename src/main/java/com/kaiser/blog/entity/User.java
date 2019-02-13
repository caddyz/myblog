package com.kaiser.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Kaiser
 * @since 2019-01-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 3906018212910186775L;
    @TableId(value = "u_id", type = IdType.AUTO)
    private Long uId;

    private String uName;

    private String uPwd;

    private String uPhone;

    private String uAddress;

    private String uEmail;

    private String uCreateTime;

    private String uSalt;


}
