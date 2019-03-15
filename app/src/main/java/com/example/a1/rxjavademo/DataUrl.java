package com.example.a1.rxjavademo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DataUrl {
    @GET
    Observable<Bean> observable(@Url String url);

//    @GET
//    Observable<String> getString(@Url String url);

}
