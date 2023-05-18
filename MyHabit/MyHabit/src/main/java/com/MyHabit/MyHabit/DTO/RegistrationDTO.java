package com.MyHabit.MyHabit.DTO;

public class RegistrationDTO {
    private String userName;

    private String password;

    private String passwordVerification;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return passwordVerification;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.passwordVerification = passwordVerification;
    }

    public boolean verifyPassword(String password, String passwordVerification){

        if(password == passwordVerification){
            return true;
        } else {
            return false;
        }

    }
}
