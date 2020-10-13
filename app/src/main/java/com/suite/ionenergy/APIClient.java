package com.suite.ionenergy;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIClient {

    @GET("3/trending/all/day?api_key=160f96cba2ae91a4be628033a7e33920")
    Call<MovieListClass> fetchList();
}
