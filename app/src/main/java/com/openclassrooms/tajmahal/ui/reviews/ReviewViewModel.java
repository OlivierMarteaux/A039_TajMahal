package com.openclassrooms.tajmahal.ui.reviews;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.openclassrooms.tajmahal.data.repository.RestaurantRepository;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;
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
            "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!",
            2
    );

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
     * Fetches the Review of the Taj Mahal restaurant.
     *
     * @return LiveData object containing the Review of the Taj Mahal restaurant.
     */
    public LiveData<Restaurant> getTajMahalRestaurant() {
        return restaurantRepository.getRestaurant();
    }

    public LiveData<List<Review>> getTajMahalReviews() {
        return restaurantRepository.getReviews();
    }

    public LiveData<Review> getUserReview() {
        return new MutableLiveData<>(userReview);
    }

}
