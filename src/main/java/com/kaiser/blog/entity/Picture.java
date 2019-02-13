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
@TableName("t_picture")
public class Picture implements Serializable {

    private static final long serialVersionUID = 2554672579287695761L;
    @TableId(value = "p_id", type = IdType.AUTO)
    private Long pId;

    private String pName;


}
