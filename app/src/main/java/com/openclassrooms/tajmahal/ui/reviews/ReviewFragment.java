package com.openclassrooms.tajmahal.ui.reviews;

import static java.lang.String.format;

import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewBinding;
import com.openclassrooms.tajmahal.databinding.FragmentReviewListBinding;
import com.openclassrooms.tajmahal.domain.model.Restaurant;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.ArrayList;
import java.util.List;
import dagger.hilt.android.AndroidEntryPoint;

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
public class ReviewFragment extends Fragment {

    private ReviewViewModel reviewViewModel;
    private FragmentReviewListBinding binding;
    private MyReviewRecyclerViewAdapter adapter;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReviewFragment() {
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment ReviewFragment.
     */
    public static ReviewFragment newInstance() {
        return new ReviewFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_review_list, container, false);
        binding = FragmentReviewListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setupViewModel();

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        reviewViewModel.getTajMahalReviews().observe(requireActivity(), new Observer<List<Review>>() {
            @Override
            public void onChanged(List<Review> reviews) {
                if (reviews == null) return;
                adapter = new MyReviewRecyclerViewAdapter(reviews);
                recyclerView.setAdapter(adapter);
                }
        });
        // Generate list of reviews:
//        detailsViewModel.getTajMahalReviews().observe(requireActivity(), new Observer<List<Review>>() {
//            @Override
//            public void onChanged(List<Review> reviews){
//                if (reviews == null) return;
//                adapter = new MyReviewRecyclerViewAdapter(reviews);
//                recyclerView.setAdapter(adapter);
//                adapter.setReviews(reviews);
//            }
//        });
//        List<Review> reviews = Arrays.asList(
//                new Review("Ranjit Singh", "https://xsgames.co/randomusers/assets/avatars/male/71.jpg", "Service très rapide et nourriture délicieuse, nous mangeons ici chaque week-end, c'est très rapide et savoureux. Continuez ainsi!", 2),
//                new Review("Martyna Siddeswara", "https://xsgames.co/randomusers/assets/avatars/female/31.jpg", "Un service excellent et des plats incroyablement savoureux. Nous sommes vraiment satisfaits de notre expérience au restaurant.", 4),
//                new Review("Komala Alanazi", "https://xsgames.co/randomusers/assets/avatars/male/46.jpg", "La cuisine est délicieuse et le service est également excellent. Le propriétaire est très sympathique et veille toujours à ce que votre repas soit satisfaisant. Cet endroit est un choix sûr!", 5),
//                new Review("David John", "https://xsgames.co/randomusers/assets/avatars/male/67.jpg", "Les currys manquaient de diversité de saveurs et semblaient tous à base de tomates. Malgré les évaluations élevées que nous avons vues et nos attentes, nous avons été déçus.", 2),
//                new Review("Emilie Hood", "https://xsgames.co/randomusers/assets/avatars/female/20.jpg", "Très bon restaurant Indien ! Je recommande.", 4)
//        );
//        recyclerView.setAdapter(new MyReviewRecyclerViewAdapter(reviews));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        reviewViewModel.getTajMahalRestaurant().observe(requireActivity(), this::updateUIWithRestaurant);
        reviewViewModel.getUserReview().observe(requireActivity(), this::updateUIWithNewReview);
    }

    private void setupViewModel() {
        reviewViewModel = new ViewModelProvider(this).get(ReviewViewModel.class);
    }

    private void updateUIWithRestaurant(Restaurant restaurant) {
        if (restaurant == null) return;
        binding.tvRestaurantName.setText(restaurant.getName());
    }

    private void updateUIWithNewReview(Review userReview){
        Glide.with(requireContext())
                .load(userReview.getPicture())
                .circleCrop()
                .placeholder(R.drawable.loading_img) // Optional: loading placeholder
                .error(R.drawable.ic_broken_image) // Optional: error image
                .into(binding.userPicture);

        binding.tvUserName.setText(userReview.getUsername());
//        binding.etUserComment.setText(userReview.getComment());
        binding.etUserComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                reviewViewModel.setUserComment(editable.toString());
                binding.buttonSubmit.setEnabled(!editable.toString().isEmpty());
            }
        });
        binding.userRate.setRating(userReview.getRate());
        binding.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reviewViewModel.addReview(new Review(userReview.getUsername(), userReview.getPicture(), userReview.getComment(), userReview.getRate()));
                for (int i = 0; i < 5; i++) {
                    System.out.println(reviewViewModel.getTajMahalReviews().getValue().get(i).getComment());
                }
                for(int i = 0; i < 20; i++){
                    adapter.notifyItemChanged(i);
                }
            }
        });
    }
}