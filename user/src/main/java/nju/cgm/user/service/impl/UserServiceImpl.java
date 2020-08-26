package nju.cgm.user.service.impl;

import nju.cgm.model.user.User;
import nju.cgm.user.dao.UserDao;
import nju.cgm.user.service.UserService;
import nju.cgm.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:43
 * @description: UserServiceImpl
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResultData create(User user) {
        return userDao.add(user);
    }

    @Override
    public ResultData modify(Map<String, Object> condition) {
        return userDao.update(condition);
    }

    @Override
    public ResultData fetch(Map<String, Object> condition) {
        return userDao.query(condition);
    }
}
