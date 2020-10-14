package com.suite.ionenergy.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.suite.ionenergy.Constants;
import com.suite.ionenergy.R;
import com.suite.ionenergy.models.MoviesListModel;
import com.suite.ionenergy.ui.MovieDetails;

import java.util.ArrayList;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder>  {

    Context context;
    ArrayList<MoviesListModel> recentListModel;


    public MoviesAdapter(Context context, ArrayList<MoviesListModel> recentListModel) {
        this.context = context;
        this.recentListModel = recentListModel;

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent, false);
        return new MoviesViewHolder(view);
    }



    @Override
    public int getItemCount() {
        return recentListModel.size();
    }



    @Override
    public void onBindViewHolder(@NonNull final MoviesViewHolder holder, final int position) {


        Glide.with(context)
                .load(Constants.BASE_URL_IMAGE + recentListModel.get(position).getPoster_path())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imageView);

        if (recentListModel.get(position).getName() != null) {
            holder.name.setText(recentListModel.get(position).getName());
        } else if (recentListModel.get(position).getTitle() != null) {
            holder.name.setText(recentListModel.get(position).getTitle());
        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent resultIntent = new Intent(context, MovieDetails.class);
                resultIntent.putExtra("name", holder.name.getText().toString());
                resultIntent.putExtra("image", recentListModel.get(position).getPoster_path());
                resultIntent.putExtra("overview", recentListModel.get(position).getOverview());
                resultIntent.putExtra("vote", recentListModel.get(position).getVote_count());
                resultIntent.putExtra("date", recentListModel.get(position).getRelease_date());
                resultIntent.putExtra("lang", recentListModel.get(position).getOriginal_language());

                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation((Activity) context,
                                holder.imageView,
                                ViewCompat.getTransitionName(holder.imageView));

                context.startActivity(resultIntent, options.toBundle());
            }
        });
    }

}