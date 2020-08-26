package nju.cgm.model.user;

import nju.cgm.model.Entity;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 20:24
 * @description: User类
 */
public class User extends Entity {

    private String userEmail;

    private String userName;

    private String userPassword;

    public User() {
        super();
    }

    public User(String userEmail, String userName, String userPassword) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
