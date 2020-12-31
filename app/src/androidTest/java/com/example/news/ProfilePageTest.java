package com.example.news;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.android21buttons.fragmenttestrule.FragmentTestRule;
import com.example.news.Fragments.profile.ProfileFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ProfilePageTest {

    @Rule
    public FragmentTestRule<?, ProfileFragment> fragmentTestRule =
            FragmentTestRule.create(ProfileFragment.class);

    @Test
    public void clickBtn() {
        onView(withId(R.id.btn_save)).perform(click());
    }

    @Test
    public void editText() {
        onView(withId(R.id.editTextName))
                .check(matches(withText("Ahmed")));

    }
}
