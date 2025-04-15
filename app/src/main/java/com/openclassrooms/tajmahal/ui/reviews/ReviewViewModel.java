package com.openclassrooms.tajmahal.ui.reviews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

/**
 * MainViewModel is responsible for preparing and managing the data for the {@link ReviewFragment}.
 * It communicates with the {@link RestaurantRepository} to fetch restaurant Review and provides
 * utility methods related to the restaurant UI.
 *
 * This ViewModel is integrated with Hilt for dependency injection.
 */
@HiltViewModel
public class ReviewViewModel extends ViewModel {

    private final RestaurantRepository restaurantRepository;

    private final Review userReview = new Review(
            "Manon Garcia",
            "https://xsgames.co/randomusers/assets/avatars/female/31.jpg",
            "",
            0
    );

    /**
     * Sets the user comment for the review.
     *
     * @param userComment The new comment to be set.
     */
    public void setUserComment(String userComment) {
        this.userReview.setComment(userComment);
    }

    /**
     * Sets the user rate for the review.
     *
     * @param userRate The new rate to be set.
     */
    public void setUserRate (int userRate){
        this.userReview.setRate(userRate);
    };

    /**
     * Constructor that Hilt will use to create an instance of MainViewModel.
     *
     * @param restaurantRepository The repository which will provide restaurant data.
     */
    @Inject
    public ReviewViewModel(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    /**
     * Fetches the restaurant TajMahal data.
     *
     * @return LiveData object containing the Taj Mahal restaurant data.
     */
    public LiveData<Restaurant> getTajMahalRestaurant() {
        return restaurantRepository.getRestaurant();
    }

    /**
     * Fetches the Review of the Taj Mahal restaurant.
     *
     * @return LiveData object containing the Review of the Taj Mahal restaurant.
     */
    public LiveData<List<Review>> getTajMahalReviews() {
        return restaurantRepository.getReviews();
    }

    /**
     * Fetches the user review for the Taj Mahal restaurant.
     *
     * @return LiveData object containing the user review for the Taj Mahal restaurant.
     */
    public LiveData<Review> getUserReview() {
        return new MutableLiveData<>(userReview);
    }

    /**
     * Adds a new {@link Review} to the beginning of the reviews list and updates the LiveData.
     *
     * <p>This method retrieves the current list of reviews from the {@code restaurantRepository}.
     * If the list is {@code null}, it initializes a new list. The new review is then inserted
     * at the top of the list (index 0), and the updated list is set back into the LiveData
     * to notify any observers.</p>
     *
     * @param review the {@code Review} object to be added to the reviews list
     */
    public void addReview(Review review) {
        List<Review> reviews = restaurantRepository.getReviews().getValue();
        if (reviews == null) {reviews = new ArrayList<>();}
        reviews.add(0,review);
        restaurantRepository.getReviews().setValue(reviews);
    }
}
