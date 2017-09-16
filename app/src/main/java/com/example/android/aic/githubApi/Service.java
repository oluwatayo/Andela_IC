package com.example.android.aic.githubApi;

import com.example.android.aic.model.ItemResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by OLUWATAYO on 15/09/2017.
 */

public interface Service {
    @GET("/search/users?q=language:java+location:lagos")
    Call<ItemResponse> getItems();
}
