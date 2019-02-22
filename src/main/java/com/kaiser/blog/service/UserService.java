package com.kaiser.blog.service;

import com.kaiser.blog.entity.LoginData;
import com.kaiser.blog.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiser.blog.util.JsonData;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kaiser
 * @since 2019-01-29
 */
public interface UserService extends IService<User> {
    JsonData login(LoginData loginData, User user);
}
