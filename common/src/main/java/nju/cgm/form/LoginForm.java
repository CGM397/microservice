package nju.cgm.form;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 22:35
 * @description: LoginForm
 */
public class LoginForm {

    private String userEmail;

    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Object[] getAllParams() {
        return new Object[]{this.userEmail, this.userPassword};
    }
}
