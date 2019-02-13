package com.kaiser.blog.service.impl;

import com.kaiser.blog.entity.Article;
import com.kaiser.blog.mapper.ArticleMapper;
import com.kaiser.blog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Kaiser
 * @since 2019-01-29
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

}
