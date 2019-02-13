package com.kaiser.blog.controller;


import com.kaiser.blog.constant.Constant;
import com.kaiser.blog.entity.Article;
import com.kaiser.blog.entity.BrowserArticle;
import com.kaiser.blog.service.ArticleService;
import com.kaiser.blog.util.JsonData;
import com.kaiser.blog.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kaiser
 * @since 2019-01-29
 */
@CrossOrigin(origins = Constant.CROS_URL)
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping("/write")
    public JsonData writeArticle(@RequestBody BrowserArticle browserArticle){
        Article article = new Article();
        article.setATitle(browserArticle.getArtTitle());
        article.setAAuthor(browserArticle.getArtAuthor());
        article.setAClassify(Arrays.toString(browserArticle.getArtLab()));
        article.setAContent(browserArticle.getArtContent());
        article.setABrief(browserArticle.getArtContent().substring(0,200));
        article.setACreateTime(TimeUtil.getNowDateTime());
        boolean save = articleService.save(article);
        if(save){
            return new JsonData("写入文章","写入成功",null,true);
        }else{
            return new JsonData("写入文章","写入成功",null,false);
        }
    }
}
