package com.openclassrooms.tajmahal.ui.reviews;

import static java.lang.String.format;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewBinding;
import com.openclassrooms.tajmahal.domain.model.Review;
import com.openclassrooms.tajmahal.ui.restaurant.DetailsViewModel;
import com.openclassrooms.tajmahal.ui.reviews.placeholder.PlaceholderContent;
import com.openclassrooms.tajmahal.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class ReviewFragment extends Fragment {

    private DetailsViewModel detailsViewModel;
    private FragmentReviewBinding binding;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ReviewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_review_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Generate list of reviews:
        List<Review> reviews = detailsViewModel.getTajMahalReviews().getValue();

        recyclerView.setAdapter(new MyReviewRecyclerViewAdapter(reviews));

        return view;
    }
}