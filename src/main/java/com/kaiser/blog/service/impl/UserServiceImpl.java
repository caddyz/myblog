package com.kaiser.blog.service.impl;

import com.kaiser.blog.entity.User;
import com.kaiser.blog.mapper.UserMapper;
import com.kaiser.blog.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
