package com.example.news.TDD_TESTS;

import com.example.news.Models.Profile.ProfilePageInterface;
import com.example.news.Models.Profile.ProfilePagePresenterInterface;
import com.example.news.Models.TypeNews.TypeNewsTestInterface;
import com.example.news.Models.TypeNews.TypeNewsTestPresenterInterface;
import com.example.news.Presenters.ProfilePagePresenter;
import com.example.news.Presenters.TypeOfActivityPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.Silent.class)

public class TypeOfPresenterTest {

    TypeNewsTestPresenterInterface typeOfPresenterTest;

    @Mock
    TypeNewsTestInterface typeNewsTestInterface;

    @Before
    public  void setUp(){
        typeOfPresenterTest = new TypeOfActivityPresenter(typeNewsTestInterface);
    }

    @Test
    public void validateData() {
        typeOfPresenterTest.checkFromData("https://feeds.alwatanvoice.com/ar/palestine.xml");
    Mockito.verify(typeNewsTestInterface).getdateofNewsAtSpicficeDay();
    }
}