package com.kaiser.blog.service.impl;

import com.kaiser.blog.entity.Notification;
import com.kaiser.blog.mapper.NotificationMapper;
import com.kaiser.blog.service.NotificationService;
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
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification> implements NotificationService {

}
