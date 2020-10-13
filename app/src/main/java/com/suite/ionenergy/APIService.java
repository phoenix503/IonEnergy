package com.suite.ionenergy;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIService {

    public static final String BASE_URL = "https://api.themoviedb.org/";

    private static Retrofit ourInstace;

    private APIClient apiClient;

    private APIService() {

    }

    public static Retrofit getInstance() {
        if (ourInstace == null)
            ourInstace = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

        return ourInstace;

    }
}

