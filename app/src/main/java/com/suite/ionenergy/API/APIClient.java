package com.suite.ionenergy.API;


import com.suite.ionenergy.models.MovieListClass;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIClient {

    @GET("3/trending/all/day?api_key=160f96cba2ae91a4be628033a7e33920")
    Call<MovieListClass> fetchList();
}
