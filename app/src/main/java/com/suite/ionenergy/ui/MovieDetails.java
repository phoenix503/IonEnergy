package com.suite.ionenergy.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.suite.ionenergy.Constants;
import com.suite.ionenergy.R;

public class MovieDetails extends AppCompatActivity {

    ImageView movieImage;
    TextView movieName, overview, movie_vote, movie_date, lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        getSupportActionBar().hide();

        initViews();
        supportPostponeEnterTransition();

        if (getIntent().getStringExtra("name") != null) {
            movieName.setText(getIntent().getStringExtra("name"));
            overview.setText(getIntent().getStringExtra("overview"));
            lang.setText(getIntent().getStringExtra("lang"));
            movie_vote.setText("" + getIntent().getIntExtra("vote", 0));
        }

        if (getIntent().getStringExtra("date") == null) {
            movie_date.setText("Date");
        } else {
            movie_date.setText(getIntent().getStringExtra("date"));
        }

        Glide.with(this)
                .load(Constants.BASE_URL_IMAGE + getIntent().getStringExtra("image"))
                .centerCrop()
                .dontAnimate()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        supportStartPostponedEnterTransition();
                        return false;
                    }

                })
                .into(movieImage);

    }

    private void initViews() {
        movieImage = findViewById(R.id.movie_image);
        movieName = findViewById(R.id.movie_name);
        overview = findViewById(R.id.movie_overview);
        movie_date = findViewById(R.id.movie_date);
        movie_vote = findViewById(R.id.movie_vote_avg);
        lang = findViewById(R.id.movie_lang);
    }
}