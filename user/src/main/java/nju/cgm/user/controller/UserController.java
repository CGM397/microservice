package nju.cgm.user.controller;

import nju.cgm.form.LoginForm;
import nju.cgm.form.RegisterForm;
import nju.cgm.model.user.User;
import nju.cgm.user.service.UserService;
import nju.cgm.util.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:49
 * @description: UserController
 */

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResultData register(RegisterForm registerForm) {
        return null;
    }

    @GetMapping("/login")
    public ResultData login(LoginForm loginForm) {
        return null;
    }

    @PostMapping("/update/user/info")
    public ResultData updateUserInfo(User user) {
        return null;
    }
}
