package com.integration.retrofit.repository;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface InitialConfigurationInterface {

  @GET("/integration-configuration/v3/hello-word")
  public Call<String> getHelloWord(
      @Header("REQUEST_ID") String request_id,
      @Header("REQUEST_DATE") String request_date,
      @Header("REQUEST_APP_CODE") String request_app_code,
      @Header("authorization") String bearerToken
  );
  
}
