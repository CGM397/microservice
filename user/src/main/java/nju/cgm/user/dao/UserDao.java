package nju.cgm.user.dao;

import nju.cgm.model.user.User;
import nju.cgm.utils.ResultData;

import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:23
 * @description: UserDao
 */
public interface UserDao {

    ResultData add(User user);

    ResultData update(Map<String, Object> condition);

    ResultData query(Map<String, Object> condition);
}
