package nju.cgm.test1.controller;

import nju.cgm.test1.service.UserService;
import nju.cgm.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Bright Chan
 * @date: 2020/8/21 14:07
 * @description: TEST
 */

@RestController
@RequestMapping("/test")
@RefreshScope
public class TestController {

    @Value("${config.info}")
    private String config;

    @Autowired
    private UserService userService;

    @GetMapping("/config")
    public String testConfig() {
        return config;
    }

    @GetMapping("/user/info")
    public ResultData showUserInfo() {
        return userService.getUserByUserEmail("980231201@qq.com");
    }
}
