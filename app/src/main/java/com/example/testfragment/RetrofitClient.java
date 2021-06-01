package com.example.testfragment;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
  private static Retrofit retrofit;
  public static Retrofit getRetrofitClient(){
      if(retrofit == null){
          retrofit = new Retrofit.Builder()
                  .baseUrl("https://track-attendance1.herokuapp.com")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build();
      }
      return retrofit;
  }
}
