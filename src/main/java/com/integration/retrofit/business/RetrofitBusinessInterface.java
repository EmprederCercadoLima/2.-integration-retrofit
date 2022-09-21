package com.integration.retrofit.business;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import com.integration.retrofit.response.GetExampleParameterByIdResponse;
import com.integration.retrofit.response.LoadHelloWordResponse;

public interface RetrofitBusinessInterface {
	public ResponseEntity<LoadHelloWordResponse> getHelloWord() throws IOException;
	public ResponseEntity<GetExampleParameterByIdResponse> getExampleParameterById(String parameterId) throws IOException;
}