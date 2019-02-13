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
@TableName("t_notification")
public class Notification implements Serializable {

    private static final long serialVersionUID = 7122858805979183148L;
    @TableId(value = "n_id", type = IdType.AUTO)
    private Integer nId;

    private String nContent;

    private String nCreateTime;


}
