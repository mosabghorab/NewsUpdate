package com.example.news.UnitTest;


import com.example.news.Models.User;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MainActivityTest {
    User user;


    @Before
    public void setup() {
        user = new User("1", "Naim", "naim.abbud@gmail.com");
    }

    @Test
    public void clickButton() {
        String firstName = user.getName().substring(0, 1).toUpperCase();
        assertTrue(firstName.equals(user.getName().substring(0, 1)));

    }
}
