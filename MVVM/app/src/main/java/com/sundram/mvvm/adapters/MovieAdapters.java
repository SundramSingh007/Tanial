package com.sundram.mvvm.adapters;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.sundram.mvvm.R;
import com.sundram.mvvm.databinding.MovieItemBinding;
import com.sundram.mvvm.model.Movie;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

public class MovieAdapters extends RecyclerView.Adapter<MovieAdapters.ViewHolder> {

    private Activity context;
    private List<Movie> movieList;
    private Map<String, Integer> localColors;
    private static final String TAG = "MovieAdapter";
    @Inject
    public MovieAdapters() {
    }

    public void setData(Activity context, List<Movie> movieList, Map<String, Integer> localColors) {
        this.context = context;
        this.movieList = movieList;
        this.localColors = localColors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MovieItemBinding movieItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.movie_item,
                parent,
                false
        );
        return new ViewHolder(movieItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            Movie movie = movieList.get(position);
            ViewHolder viewHolder = (ViewHolder) holder;
            //it will bind data to view
            viewHolder.movieItemBinding.setSearchData(movie);

            String[] movieArr = movie.getOriginal_title().replaceAll("[^a-zA-Z0-9\\s]", "").split(" ");

            for (String colorName:
                    movieArr) {
                colorName.toLowerCase().replace(",", "");
                if (localColors.containsKey(colorName.toLowerCase().replace(",", ""))){
                    viewHolder.movieItemBinding.container.setBackgroundColor(localColors.get(colorName.toLowerCase()));
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding movieItemBinding;

        public ViewHolder(@NonNull MovieItemBinding itemView) {
            super(itemView.getRoot());
            this.movieItemBinding = itemView;
        }
    }
}
