package nju.cgm.user.dao.impl;

import nju.cgm.model.user.User;
import nju.cgm.user.dao.BaseDao;
import nju.cgm.user.dao.UserDao;
import nju.cgm.util.ResponseCode;
import nju.cgm.util.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:23
 * @description: UserDaoImpl
 */

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public ResultData add(User user) {
        ResultData result = new ResultData();
        try {
            sqlSession.insert("ms.user_info.user.insert", user);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
            logger.error("add failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData update(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            sqlSession.update("ms.user_info.user.update", condition);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
            logger.error("update failed: " + e.getMessage());
        }
        return result;
    }

    @Override
    public ResultData query(Map<String, Object> condition) {
        ResultData result = new ResultData();
        try {
            List<User> userList = sqlSession.selectList("ms.user_info.user.query", condition);
            if (userList.isEmpty()) {
                result.setResponseCode(ResponseCode.RESPONSE_NULL);
            }
            result.setData(userList);
        } catch (Exception e) {
            result.setResponseCode(ResponseCode.RESPONSE_ERROR);
            result.setDescription(e.getMessage());
            logger.error("query failed: " + e.getMessage());
        }
        return result;
    }
}
