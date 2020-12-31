package com.example.news.UnitTest;

import com.example.news.Models.User;
import com.example.news.Utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InputsTest {
    User user;
    Utils utils;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("BeforeClass");
    }

    @Before
    public void before() {
        System.out.println("Before");
        utils = new Utils();
        user = new User("1","mosab","mosab@gmail.com");
    }

    @Test
    public void validateMobile() {
        System.out.println("validate mobile");
        assertTrue(utils.validateMobileNumber(user.getMobile()));
    }

    @Test
    public void validateEmail() {
        System.out.println("validate email");
        assertTrue(utils.validateEmail(user.getEmail()));
    }

    @Test
    public void validatePassword() {
        System.out.println("validate password");
        assertTrue(utils.validatePassword(user.getPassword()));
    }

    @After
    public void after() {
        System.out.println("After");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("AfterClass");
    }
}
