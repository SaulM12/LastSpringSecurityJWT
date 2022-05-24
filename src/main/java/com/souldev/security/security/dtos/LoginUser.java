package com.souldev.security.security.dtos;

import javax.validation.constraints.NotBlank;

public class LoginUser {
    @NotBlank
    private String userName;
    @NotBlank
    private String password;
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
    
}
