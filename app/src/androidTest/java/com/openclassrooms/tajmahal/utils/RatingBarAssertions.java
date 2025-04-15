package com.openclassrooms.tajmahal.utils;

import android.view.View;
import android.widget.RatingBar;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import static org.junit.Assert.*;

public class RatingBarAssertions {
    public static ViewAssertion hasRating(final float expectedRating) {
        return new ViewAssertion() {
            @Override
            public void check(View view, NoMatchingViewException noViewFoundException) {
                if (noViewFoundException != null) {
                    throw noViewFoundException;
                }

                if (!(view instanceof RatingBar)) {
                    throw new AssertionError("The view is not a RatingBar");
                }

                RatingBar ratingBar = (RatingBar) view;
                assertEquals("RatingBar has unexpected rating", expectedRating, ratingBar.getRating(), 0.01);
            }
        };
    }
}
