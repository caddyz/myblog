package com.kaiser.blog.controller;


import com.kaiser.blog.constant.Constant;
import com.kaiser.blog.entity.Picture;
import com.kaiser.blog.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;
    @GetMapping("/t1")
    public String t1(){
        return "ssss";
    }
    @GetMapping("/getPic")
    private Picture getPic(){
        return pictureService.getById(1);
    }
}
