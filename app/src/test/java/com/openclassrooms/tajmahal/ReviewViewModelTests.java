package com.openclassrooms.tajmahal;

import static com.openclassrooms.tajmahal.LiveDataTestUtil.getOrAwaitValue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.data.service.RestaurantFakeApi;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.reviews.ReviewViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ReviewViewModelTests {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();
    private ReviewViewModel viewModel;

    @Before
    public void setup() {
        viewModel = new ReviewViewModel(new RestaurantRepository(new RestaurantFakeApi()));
    }

    @Test
    public void reviewViewModel_AddNewReview_UpdatesTajMahalReviews()  {
        List<Review> initialReviews = viewModel.getTajMahalReviews().getValue();
        viewModel.addReview(new Review("Manon Garcia", "https://example.com/avatar.jpg", "Great restaurant!", 5));
        List<Review> finalReviews = viewModel.getTajMahalReviews().getValue();
        assertTrue(true);
        assertEquals(initialReviews.size()+1 , finalReviews.size());
    }
}


