package com.example.news.Presenters;

import com.example.news.Models.Signup.SignupTestPresenterInterface;

public class SiginupActivityPresenter implements SignupTestPresenterInterface {
    com.example.news.Models.Signup.SignupTestInterface SignupTestInterface;
    public SiginupActivityPresenter(com.example.news.Models.Signup.SignupTestInterface SignupTestInterface) {
        this.SignupTestInterface = SignupTestInterface;
    }

    @Override
    public void checkFromData(String name,String email, String password,String confrimpassword) {
        if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty() && !confrimpassword.isEmpty()) {
            SignupTestInterface.sendRequestSignup();
        } else {
            SignupTestInterface.showErrorMessage();
        }


    }
}
