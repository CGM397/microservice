package nju.cgm.user.service.impl;

import nju.cgm.constant.MsConstant;
import nju.cgm.model.user.User;
import nju.cgm.user.dao.UserDao;
import nju.cgm.user.service.UserService;
import nju.cgm.utils.MyCast;
import nju.cgm.utils.ResponseCode;
import nju.cgm.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public ResultData createNewUser(User user) {
        return userDao.add(user);
    }

    @Override
    public ResultData modifyUserInfo(Map<String, Object> condition) {
        return userDao.update(condition);
    }

    @Override
    public ResultData fetch(Map<String, Object> condition) {
        return userDao.query(condition);
    }

    @Override
    public ResultData fetchByUserEmail(String userEmail) {
        ResultData res = new ResultData();
        Map<String, Object> condition = new HashMap<>();

        condition.put("userEmail", userEmail);
        condition.put("blockFlag", false);
        ResultData response = fetch(condition);
        if (response.getResponseCode() == ResponseCode.RESPONSE_OK) {
            res.setData(new MyCast<User>().castToList(response.getData()).get(0));
        }
        else {
            res.setResponseCode(ResponseCode.RESPONSE_ERROR);
            res.setDescription(MsConstant.ResponseDesc.CANNOT_FIND);
        }
        return res;
    }

    @Override
    public ResultData identityVerification(Map<String, Object> condition) {
        ResultData res = new ResultData();

        condition.put("blockFlag", false);
        ResultData response = fetch(condition);
        if (response.getResponseCode() != ResponseCode.RESPONSE_OK) {
            res.setResponseCode(ResponseCode.RESPONSE_ERROR);
            res.setDescription(MsConstant.ResponseDesc.CANNOT_FIND);
        }
        return res;
    }
}
