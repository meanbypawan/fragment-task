package com.example.testfragment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BatchApi {
  @GET("/batch/{fid}/{status}")
  public Call<ArrayList<Batch>> getBatchList(@Path("fid") int fid,@Path("status") String status);
}
