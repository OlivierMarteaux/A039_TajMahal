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

public class MyReviewRecyclerViewAdapter extends RecyclerView.Adapter<MyReviewRecyclerViewAdapter.ViewHolder> {

    private List<Review> reviews;

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public MyReviewRecyclerViewAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    public void updateList() {
        notifyDataSetChanged(); // Full refresh (not always efficient)
    }

    public void updateItem(int position, Review review) {
        if (position < reviews.size()) {
            reviews.set(position, review);
            notifyItemChanged(position); // Refresh only one item
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentReviewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

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

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView reviewPicture;
        TextView reviewComment;
        RatingBar reviewStars;
        TextView reviewName;

        public ViewHolder(FragmentReviewBinding binding) {
            super(binding.getRoot());
            reviewPicture = binding.reviewPicture;
            reviewName = binding.reviewName;
            reviewComment = binding.reviewComment;
            reviewStars = binding.reviewStars;
        }
    }
}