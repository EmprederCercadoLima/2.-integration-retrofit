package com.integration.retrofit.repository;

import com.integration.retrofit.response.GetExampleParameterByIdResponse;
import com.integration.retrofit.response.HelloWordResponse;
import com.integration.retrofit.response.LoadHelloWordResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

public interface RetrofitInterface {

	 @GET("/v1/hello-word")
	 public Call<LoadHelloWordResponse> getHelloWord(
			 @Header("REQUEST_ID") String request_id,
			 @Header("REQUEST_DATE") String request_date,
			 @Header("REQUEST_APP_CODE") String request_app_code,
			 @Header("authorization") String bearerToken
	 );
	 
	 @GET("/{parameterId}")
	 public Call<GetExampleParameterByIdResponse> getExampleParameterById(@Path("parameterId") String parameterId);

}