package com.example.androiduitesting;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> scenario =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testActivitySwitch() {
        // Add a city first
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Edmonton"));
        onView(withId(R.id.button_confirm)).perform(click());

        // Click on the city in the list
        onView(withText("Edmonton")).perform(click());

        // Verify that the new activity (ShowActivity) is displayed
        onView(withId(R.id.textView_cityName)).check(matches(isDisplayed()));
    }

    @Test
    public void testCityNameConsistency() {
        // Add and click city
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Vancouver"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Vancouver")).perform(click());

        // Check that ShowActivity displays the correct city name
        onView(withId(R.id.textView_cityName)).check(matches(withText("Vancouver")));
    }

    @Test
    public void testBackButton() {
        // Add and click city
        onView(withId(R.id.button_add)).perform(click());
        onView(withId(R.id.editText_name)).perform(ViewActions.typeText("Tokyo"));
        onView(withId(R.id.button_confirm)).perform(click());
        onView(withText("Tokyo")).perform(click());

        // Click the back button
        onView(withId(R.id.button_back)).perform(click());

        // Verify that we're back in MainActivity (list should be visible)
        onView(withId(R.id.city_list)).check(matches(isDisplayed()));
    }
}
