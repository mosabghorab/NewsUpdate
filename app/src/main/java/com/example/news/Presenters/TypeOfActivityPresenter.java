package com.example.news.Presenters;

import com.example.news.Models.Login.LogInTestInterface;
import com.example.news.Models.Login.LogInTestPresenterInterface;
import com.example.news.Models.TypeNews.TypeNewsTestInterface;
import com.example.news.Models.TypeNews.TypeNewsTestPresenterInterface;

public class TypeOfActivityPresenter implements TypeNewsTestPresenterInterface {
    TypeNewsTestInterface typeNewsTestInterface;

    public TypeOfActivityPresenter(TypeNewsTestInterface typeNewsTestInterface) {
        this.typeNewsTestInterface = typeNewsTestInterface;
    }



    @Override
    public void checkFromData(String url) {
        if (url.equals("https://www.alwatanvoice.com/arabic/news/2020/12/28/1390093.html")){
            typeNewsTestInterface.getdateofNewsAtSpicficeDay();
        }else {
            typeNewsTestInterface.showErrorMessage();
        }

    }
}
