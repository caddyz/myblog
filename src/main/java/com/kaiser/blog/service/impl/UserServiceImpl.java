package com.kaiser.blog.service.impl;

import com.kaiser.blog.constant.Constant;
import com.kaiser.blog.entity.LoginData;
import com.kaiser.blog.entity.ToBrowserUser;
import com.kaiser.blog.entity.User;
import com.kaiser.blog.mapper.UserMapper;
import com.kaiser.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiser.blog.util.JsonData;
import com.kaiser.blog.util.JwtUtil;
import com.kaiser.blog.util.RandomStrUtil;
import com.kaiser.blog.util.UserUtil;
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
    @Override
    public JsonData login(LoginData loginData, User user) {
        ToBrowserUser browserUser = new ToBrowserUser();
        boolean userJudge = UserUtil.judgeUser(loginData.getPassword(), user.getUPwd(), user.getUSalt());
        try {
            String token = JwtUtil.createJwt(RandomStrUtil.getUUID(), user.toString(), Constant.JWT_TTLMILLS);
            browserUser.setToken(token);
            browserUser.setUserId(user.getUId());
            browserUser.setUserName(user.getUName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userJudge? new JsonData("登陆","登陆成功",browserUser,userJudge):new JsonData("登陆","用户名或密码错误",null,userJudge);

    }
}
