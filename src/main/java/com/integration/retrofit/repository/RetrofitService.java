package com.integration.retrofit.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.integration.retrofit.response.GetExampleParameterByIdResponse;
import com.integration.retrofit.response.LoadHelloWordResponse;

import retrofit2.Call;
import retrofit2.Response;

@Service
public class RetrofitService {

    private static final String REQUEST_ID_VALUE = "mock_request_id";
    private static final String REQUEST_DATE_VALUE = "mock_request_date";
    private static final String REQUEST_APP_CODE_VALUE = "mock_request_app_code";
    
    private static final String REQUEST_BEARER_TOKEN_COMMERCE = "Bearer REQUEST_BEARER_TOKEN_COMMERCE_";
	
	@Autowired
	private RetrofitInterface retrofitInterface;
	
	public LoadHelloWordResponse getHelloWord() throws IOException {
		Call<LoadHelloWordResponse> retrofitCall = retrofitInterface.getHelloWord(REQUEST_ID_VALUE, REQUEST_DATE_VALUE, REQUEST_APP_CODE_VALUE, REQUEST_BEARER_TOKEN_COMMERCE);
        Response<LoadHelloWordResponse> response = retrofitCall.execute();
        if (response != null && !response.isSuccessful() && response.errorBody() != null) {
        	Gson gson = new Gson();
        	LoadHelloWordResponse message = gson.fromJson(response.errorBody().charStream(), LoadHelloWordResponse.class);
        	return message;
        }
        return response.body();
	}
	
	public GetExampleParameterByIdResponse getExampleParameterById(String parameterId)  throws IOException {
		Call<GetExampleParameterByIdResponse> retrofitCall = retrofitInterface.getExampleParameterById(parameterId);
		Response<GetExampleParameterByIdResponse> response = retrofitCall.execute();
		return response.body();
	}
	

}
