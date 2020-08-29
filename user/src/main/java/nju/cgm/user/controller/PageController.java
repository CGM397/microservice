package nju.cgm.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Bright Chan
 * @date: 2020/8/28 15:26
 * @description: 页面
 */

@Controller
public class PageController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
