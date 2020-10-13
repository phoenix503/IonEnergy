package com.suite.ionenergy;

import android.media.Image;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class MoviesViewHolder extends RecyclerView.ViewHolder {
    protected TextView name;
    protected ImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public MoviesViewHolder(@NonNull View view) {
        super(view);

        name = view.findViewById(R.id.movie_name);
        imageView = view.findViewById(R.id.movie_pic);


    }

}
