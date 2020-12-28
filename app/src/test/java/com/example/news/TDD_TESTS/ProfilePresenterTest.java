package com.example.news.TDD_TESTS;

import com.example.news.Models.Profile.ProfilePageInterface;
import com.example.news.Models.Profile.ProfilePagePresenterInterface;
import com.example.news.Presenters.ProfilePagePresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.Silent.class)

public class ProfilePresenterTest {

    ProfilePagePresenterInterface profilePagePresenterInterface;

    @Mock
    ProfilePageInterface profilePageInterface;


    @Before
    public  void setUp(){
        profilePagePresenterInterface = new ProfilePagePresenter(profilePageInterface);
    }

    @Test
    public void validateInputsData() {
    profilePagePresenterInterface.validateData("mosab@gmail.com" , "mrmosab","Mosab");
    Mockito.verify(profilePageInterface).sendUpdateRequestToServer();
    }
}