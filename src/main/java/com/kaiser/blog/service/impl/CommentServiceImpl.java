package com.kaiser.blog.service.impl;

import com.kaiser.blog.entity.Comment;
import com.kaiser.blog.mapper.CommentMapper;
import com.kaiser.blog.service.CommentService;
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
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
