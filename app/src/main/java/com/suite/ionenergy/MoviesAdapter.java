package com.suite.ionenergy;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.logging.Filter;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

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
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {


            Glide.with(context)
                    .load("https://image.tmdb.org/t/p/w185/"+recentListModel.get(position).getPoster_path())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(holder.imageView);

            holder.name.setText(recentListModel.get(position).getName());




//        holder.itemcard.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(context, FeedDetails.class);
//                i.putExtra("post_uuid", holder.id.getText().toString());
//                context.startActivity(i);
//            }
//        });
    }

}