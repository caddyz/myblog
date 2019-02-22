package com.kaiser.blog.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaiser.blog.constant.Constant;
import com.kaiser.blog.entity.ForeRegister;
import com.kaiser.blog.entity.LoginData;
import com.kaiser.blog.entity.ToBrowserUser;
import com.kaiser.blog.entity.User;
import com.kaiser.blog.service.UserService;
import com.kaiser.blog.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public JsonData userLogin(@RequestBody LoginData loginData){
        User one = userService.getOne(new QueryWrapper<User>().eq("u_name", loginData.getName()));
        if(one == null){
            return new JsonData("登陆","用户未注册",null,false);
        }
        return userService.login(loginData,one);
    }
    @PostMapping("/register")
    @ResponseBody
    public JsonData userRegister(@RequestBody ForeRegister register){
        String uuid = RandomStrUtil.getUUID();
        User user = new User();
        user.setUName(register.getName());
        user.setUPhone(register.getPhone());
        user.setUEmail(register.getEmail());
        user.setUPwd(Encryption.md5(register.getPass().concat(uuid)));
        user.setUCreateTime(TimeUtil.getNowDateTime());
        user.setUAddress(Arrays.toString(register.getAddress()));
        user.setUSalt(uuid);
        boolean save = userService.save(user);
        if(save){
            return new JsonData("注册信息","注册成功",null,true);
        }
        return new JsonData("注册信息","注册失败",null,false);
    }
    @GetMapping("/checkUserName/{userName}")
    @ResponseBody
    public JsonData checkUserName(@PathVariable String userName){
        User user = userService.getOne(new QueryWrapper<User>().eq("u_name", userName));
        if (user==null){
            return new JsonData("获取user数据","没有user数据",null,false);
        }else {
            return new JsonData("获取user数据","获取到了user数据",user,true);
        }
    }
}
