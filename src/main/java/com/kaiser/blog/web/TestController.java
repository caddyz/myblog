package com.kaiser.blog.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author Kaiser
 * @Date 2019/1/29 22:58
 * @Version 1.0
 **/
@RestController
public class TestController {
    @GetMapping("test")
    public String test(){
        return "NNN";
    }
    @GetMapping("/test1/{de}")
    public String test1(@PathVariable String de){
        System.out.println("获取数据为："+de);
        return "NNN" + de;
    }
}
