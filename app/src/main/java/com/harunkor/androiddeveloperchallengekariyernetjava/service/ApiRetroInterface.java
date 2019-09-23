package com.harunkor.androiddeveloperchallengekariyernetjava.service;

import com.harunkor.androiddeveloperchallengekariyernetjava.model.Order;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRetroInterface {


    @GET("/")   //  ornek :  @GET("/orderlist.json") main olarak ayarlandığında
    Call<List<Order>> OrdersAll();


}
