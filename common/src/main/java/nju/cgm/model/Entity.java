package nju.cgm.model;

import java.sql.Timestamp;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 20:28
 * @description: Entity类，抽象类，必须被继承，不能被实例化
 */
public abstract class Entity {

    protected boolean blockFlag;

    //Timestamp继承自java.util.Date
    protected Timestamp createTime;

    public Entity() {
        this.blockFlag = false;
        this.createTime = new Timestamp(System.currentTimeMillis());
    }

    public boolean isBlockFlag() {
        return blockFlag;
    }

    public void setBlockFlag(boolean blockFlag) {
        this.blockFlag = blockFlag;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
