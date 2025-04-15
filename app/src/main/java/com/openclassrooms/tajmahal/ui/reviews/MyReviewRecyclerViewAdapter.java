package com.openclassrooms.tajmahal.ui.reviews;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.openclassrooms.tajmahal.R;
import com.openclassrooms.tajmahal.databinding.FragmentReviewBinding;
import com.openclassrooms.tajmahal.domain.model.Review;

import java.util.List;


/**
 * RecyclerView Adapter for displaying a list of {@link Review} objects.
 * This adapter uses a custom ViewHolder and supports list and item updates.
 */
public class MyReviewRecyclerViewAdapter extends RecyclerView.Adapter<MyReviewRecyclerViewAdapter.ViewHolder> {

    private List<Review> reviews;

    /**
     * Sets a new list of reviews to be displayed by the adapter.
     *
     * @param reviews the list of {@link Review} objects.
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Constructs a new {@code MyReviewRecyclerViewAdapter} with the given list of reviews.
     *
     * @param reviews the initial list of {@link Review} objects.
     */
    public MyReviewRecyclerViewAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * Updates the entire list. This causes the adapter to refresh all items.
     * Use with caution for performance-sensitive scenarios.
     */
    public void updateList() {
        notifyDataSetChanged(); // Full refresh (not always efficient)
    }

    /**
     * Updates a single item at the specified position.
     *
     * @param position the index of the item to update.
     * @param review   the new {@link Review} object to replace the old one.
     */
    public void updateItem(int position, Review review) {
        if (position < reviews.size()) {
            reviews.set(position, review);
            notifyItemChanged(position); // Refresh only one item
        }
    }

    /**
     * Inflates the layout and creates a new {@link ViewHolder}.
     *
     * @param parent   the parent {@link ViewGroup}.
     * @param viewType the view type of the new View.
     * @return a new {@link ViewHolder} that holds the inflated layout.
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentReviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    /**
     * Binds a {@link Review} object to a {@link ViewHolder}.
     *
     * @param holder   the ViewHolder to update.
     * @param position the position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Review review = reviews.get(position);
//        holder.reviewPicture.setImageResource();

//        Picasso.get()
//                .load(review.getPicture())
//                .placeholder(R.drawable.loading_img)
//                .error(R.drawable.ic_broken_image)
//                .into(holder.reviewPicture);

        Glide.with(holder.itemView.getContext())
                .load(review.getPicture())
                .circleCrop()
                .placeholder(R.drawable.loading_img) // Optional: loading placeholder
                .error(R.drawable.ic_broken_image) // Optional: error image
                .into(holder.reviewPicture);

        holder.reviewComment.setText(review.getComment());
        holder.reviewName.setText(review.getUsername());
        holder.reviewStars.setRating(review.getRate());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return the item count.
     */
    @Override
    public int getItemCount() {
        return reviews.size();
    }

    /**
     * ViewHolder class that holds the UI components for each review item.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView reviewPicture;
        TextView reviewComment;
        RatingBar reviewStars;
        TextView reviewName;

        /**
         * Constructs a new ViewHolder with the given binding.
         *
         * @param binding the view binding for the review item layout.
         */
        public ViewHolder(FragmentReviewBinding binding) {
            super(binding.getRoot());
            reviewPicture = binding.reviewPicture;
            reviewName = binding.reviewName;
            reviewComment = binding.reviewComment;
            reviewStars = binding.reviewStars;
        }
    }
}