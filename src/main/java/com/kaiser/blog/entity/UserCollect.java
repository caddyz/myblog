package com.kaiser.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("t_user_collect")
public class UserCollect implements Serializable {

    private static final long serialVersionUID = -6167055246462354042L;
    private Long uId;

    private Long aId;

    private Boolean userLike;

    private Boolean userCollect;


}
