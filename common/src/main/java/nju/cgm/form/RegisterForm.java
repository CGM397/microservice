package nju.cgm.form;

/**
 * @author: Bright Chan
 * @date: 2020/8/26 22:38
 * @description: RegisterForm
 */
public class RegisterForm {

    private String userEmail;

    private String userName;

    private String userPassword;

    private String verificationCode;

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

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
