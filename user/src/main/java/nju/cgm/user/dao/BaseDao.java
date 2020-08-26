package nju.cgm.user.dao;

import org.apache.ibatis.session.SqlSession;

import javax.annotation.Resource;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 21:23
 * @description: BaseDao
 */
public class BaseDao {

    @Resource
    protected SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}
