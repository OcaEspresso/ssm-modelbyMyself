package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 测试文件，测试成功 2025/2/20 21:53
 * @author: RicksonYu
 * @create: 2025年-02月-20日--21:47
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){

        return "world";
    }
}
