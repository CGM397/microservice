package nju.cgm.user.service;

import nju.cgm.model.user.User;
import nju.cgm.util.ResultData;

import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:41
 * @description: UserService
 */
public interface UserService {

    ResultData create(User user);

    ResultData modify(Map<String, Object> condition);

    ResultData fetch(Map<String, Object> condition);
}
