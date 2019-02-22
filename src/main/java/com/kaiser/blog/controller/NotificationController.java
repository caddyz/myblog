package com.kaiser.blog.controller;


import com.kaiser.blog.constant.Constant;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/notification")
public class NotificationController {

}
