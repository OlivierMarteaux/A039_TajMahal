package com.openclassrooms.tajmahal.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static com.openclassrooms.tajmahal.utils.RatingBarMatcher.withRating;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.utils.RatingBarActions;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewReviewTests {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        onView(withId(R.id.tvLeaveAComment)).perform(scrollTo(), click());
    }

    @Test
    public void leaveAComment_3StarsWithFullComment_SubmittedAndShownInFirstPosition() {
        onView(withId(R.id.etUserComment)).perform(replaceText("Très bon restaurant"), closeSoftKeyboard());
        onView(withId(R.id.userRate)).perform(RatingBarActions.setRating(3.0f));
        onView(withId(R.id.buttonSubmit)).perform(click());

        onView(withId(R.id.list))
                .perform(RecyclerViewActions.scrollToPosition(0))
                .check(matches(hasDescendant(allOf(withId(R.id.reviewComment), withText("Très bon restaurant")))))
                .check(matches(hasDescendant(allOf(withId(R.id.reviewName), withText("Manon Garcia")))))
                .check(matches(hasDescendant(allOf(withId(R.id.reviewStars), withRating(3.0f)))));
    }

    @Test
    public void leaveAComment_EmptyComment_CannotSubmit() {
        onView(withId(R.id.buttonSubmit)).perform(click());
        onView(withId(R.id.buttonSubmit)).check(matches(isNotEnabled()));
    }
}