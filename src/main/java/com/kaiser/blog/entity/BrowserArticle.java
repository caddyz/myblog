package com.kaiser.blog.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BrowserArticle
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/2/5 17:00
 * @Version 1.0
 **/
@Data
public class BrowserArticle implements Serializable {
    private static final long serialVersionUID = -1227943086858310069L;
    private String[] artLab;
    private String artTitle;
    private String artContent;
    private String artAuthor;
}
