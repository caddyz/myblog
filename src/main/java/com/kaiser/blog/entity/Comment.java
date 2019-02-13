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
@TableName("t_comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = -4746550222197191004L;
    @TableId(value = "c_id", type = IdType.AUTO)
    private Long cId;

    private Long cThemeId;

    /**
     * 璇勮鍥炲浜虹殑鍚嶅瓧
     */
    private String cReplyName;

    private String cContent;

    private String cCreateTime;

    /**
     * 闂佹悶鍎抽崑娑⑺囬懠顒佸珰闁告洦鍣崯鍫ユ煟閵娿儱顏ф慨鐟邦樀閹啴宕熼锝呪偓鎶芥倵?
     */
    private String cReplyedName;


}
