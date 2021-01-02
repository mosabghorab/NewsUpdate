package com.example.news;

import androidx.test.rule.ActivityTestRule;

import com.example.news.Activities.LogInActivity;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class LoginEditTextTest {
    @Rule
    public ActivityTestRule<LogInActivity> homeActivity = new ActivityTestRule<LogInActivity>(
            LogInActivity.class);


    @Test
    public void editText() {
        onView(withId(R.id.emailLogInEdt))
                .check(matches(withText("naim.abbud@gmail.com")));

    }
}
