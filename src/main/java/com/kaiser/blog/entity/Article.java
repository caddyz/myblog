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
@TableName("t_article")
public class Article implements Serializable {

    private static final long serialVersionUID = -2348601222920555468L;
    @TableId(value = "a_id", type = IdType.AUTO)
    private Long aId;

    private String aTitle;

    private String aBrief;

    private String aContent;

    private String aAuthor;

    private Long aRead;

    private Long aCollect;

    private String aCreateTime;

    private String aClassify;


}
