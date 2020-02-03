package com.antailbaxt3r.shortme.retrofit;

import com.antailbaxt3r.shortme.models.URLResponse;
import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("api/url/shorten")
    Call<URLResponse> sendURL(@Body Map<String, String> body);
}
