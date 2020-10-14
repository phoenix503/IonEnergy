package com.suite.ionenergy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        initViews();
        fetchMoviesList();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.movielist);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

    }

    private void fetchMoviesList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIClient service = retrofit.create(APIClient.class);

        Call<MovieListClass> call = service.fetchList();
        call.enqueue(new Callback<MovieListClass>() {
            @Override
            public void onResponse(Call<MovieListClass> call, Response<MovieListClass> response) {
                switch (response.code()){
                    case 200:
                        Log.e("response", response.body().getResults().get(0).getName());
                        MoviesAdapter moviesAdapter = new MoviesAdapter(MainActivity.this, response.body().getResults());
                        recyclerView.setAdapter(moviesAdapter);
                        break;
                    case 404:
                        Log.e("response",  response.body().getStatus_message());
                        break;
                    case 401:
                        Log.e("response", response.body().getStatus_message());
                        break;
                }

            }

            @Override
            public void onFailure(Call<MovieListClass> call, Throwable t) {
                Log.e("failed", t.getMessage());

            }
        });
    }
}