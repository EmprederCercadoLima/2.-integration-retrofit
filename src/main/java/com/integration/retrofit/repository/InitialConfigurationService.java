package com.integration.retrofit.repository;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class InitialConfigurationService {
  
  private static final String REQUEST_ID_VALUE = "mock_request_id";
  private static final String REQUEST_DATE_VALUE = "mock_request_date";
  private static final String REQUEST_APP_CODE_VALUE = "mock_request_app_code";
  
  private static final String REQUEST_BEARER_TOKEN_COMMERCE = "Bearer REQUEST_BEARER_TOKEN_COMMERCE";
  
  @Autowired
  private InitialConfigurationInterface initialConfigurationInterface;

  public String getHelloWord() throws IOException {
    Call<String> retrofitCall = initialConfigurationInterface.getHelloWord(REQUEST_ID_VALUE, REQUEST_DATE_VALUE, REQUEST_APP_CODE_VALUE, REQUEST_BEARER_TOKEN_COMMERCE);
    Response<String> response = retrofitCall.execute();
    System.out.println("1Hola usuario bienvenido" + response);
    return response.body();
    
  }
}
