package com.example.news;

import androidx.test.rule.ActivityTestRule;

import com.example.news.Activities.LogInActivity;
import com.example.news.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class LogInButtonTest {

    @Rule
    public ActivityTestRule<LogInActivity> homeActivity = new ActivityTestRule<LogInActivity>(
            LogInActivity.class);

    @Before
    public void setUp(){

    }

    @Test
    public  void test(){
        //onView(withId(R.id.Next)).perform(click());
        onView(withId(R.id.loginInBtn)).check(matches(isDisplayed()));
    }
}
