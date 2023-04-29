package com.example.mrmovie.retrofit;

public class ApiUtils {
    private ApiInterface apiInterface;

    public static ApiInterface getInstance(){
        return RetrofitClient.getInstanceWithLogging().create(ApiInterface.class);
    }
}
