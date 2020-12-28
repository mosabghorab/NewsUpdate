package com.example.news.TDD_TESTS;


import com.example.news.Models.Signup.SignupTestInterface;
import com.example.news.Presenters.SiginupActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.Silent.class)

public class SignupPresenterTest {
   SiginupActivityPresenter siginupActivityPresenter;

    @Mock
    SignupTestInterface signupTestInterface;


    @Before
    public  void setUp(){
        siginupActivityPresenter = new SiginupActivityPresenter(signupTestInterface);
    }

    @Test
    public void checkIfSinupAttemptIsExceeded() {
        siginupActivityPresenter.checkFromData("" , "","123456789","123456789");
        Mockito.verify(signupTestInterface).showErrorMessage();
    }}



