package com.example.news.UnitTest;

import com.example.news.Models.News;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FavoriteTest {


    News news;

    @BeforeClass
    public static void beforeClassMethod() {
        System.out.println("BeforeClass");
    }

    @Before
    public void beforeMethod() {
        System.out.println("Before");
        news = new News(true);

    }

    @Test
    public void testMethod() {
        assertTrue(news.getIsFavorite());
    }

    @After
    public void AfterMethod() {
        System.out.println("After");
        news = null;

    }

    @AfterClass
    public static void AfterClassMethod() {
        System.out.println("AfterClass");

    }


}
