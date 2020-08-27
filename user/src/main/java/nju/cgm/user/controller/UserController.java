package nju.cgm.user.controller;

import nju.cgm.constant.MsConstant;
import nju.cgm.form.LoginForm;
import nju.cgm.form.RegisterForm;
import nju.cgm.model.user.User;
import nju.cgm.user.service.UserService;
import nju.cgm.utils.ResponseCode;
import nju.cgm.utils.ResultData;
import nju.cgm.utils.ParamCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
        ResultData res = new ResultData();

        if (ParamCheck.ObjectIsEmpty(loginForm.getAllParams())) {
            res.setResponseCode(ResponseCode.RESPONSE_ERROR);
            res.setDescription(MsConstant.ResponseDesc.PARAM_EMPTY);
        }
        else {
            Map<String, Object> condition = new HashMap<>();
            condition.put("userEmail", loginForm.getUserEmail());
            condition.put("userPassword", loginForm.getUserPassword());

            ResultData response = userService.identityVerification(condition);
            if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
                res.setResponseCode(ResponseCode.RESPONSE_ERROR);
                res.setDescription("login failed: " + response.getDescription());
                logger.error(res.getDescription());
            }
        }
        return res;
    }

    @PostMapping("/update/user/info")
    public ResultData updateUserInfo(User user) {
        return null;
    }
}
