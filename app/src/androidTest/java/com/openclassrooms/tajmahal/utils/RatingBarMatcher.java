package com.openclassrooms.tajmahal.utils;

import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Espresso matcher to check the rating of a RatingBar.
 */
public class RatingBarMatcher {

    /**
     * Returns a matcher that matches a RatingBar with the given rating.
     *
     * @param expectedRating The expected rating to match.
     * @return A matcher that matches a RatingBar with the specified rating.
     */
    public static Matcher<View> withRating(final float expectedRating) {
        return new BoundedMatcher<View, RatingBar>(RatingBar.class) {
            @Override
            protected boolean matchesSafely(RatingBar ratingBar) {
                return Math.abs(ratingBar.getRating() - expectedRating) < 0.01;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with rating: " + expectedRating);
            }
        };
    }
}
