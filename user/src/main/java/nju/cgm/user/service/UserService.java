package nju.cgm.user.service;

import nju.cgm.model.user.User;
import nju.cgm.utils.ResultData;

import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:41
 * @description: UserService
 */
public interface UserService {

    ResultData createNewUser(User user);

    ResultData modifyUserInfo(Map<String, Object> condition);

    ResultData fetch(Map<String, Object> condition);

    ResultData fetchByUserEmail(String userEmail);

    ResultData identityVerification(Map<String, Object> condition);
}
