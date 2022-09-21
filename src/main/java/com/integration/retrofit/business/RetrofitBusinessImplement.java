package com.integration.retrofit.business;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.integration.retrofit.repository.RetrofitService;
import com.integration.retrofit.response.GetExampleParameterByIdResponse;
import com.integration.retrofit.response.LoadHelloWordResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RetrofitBusinessImplement implements RetrofitBusinessInterface {

	@Autowired
	private RetrofitService retrofitService;

	@Override
	public ResponseEntity<LoadHelloWordResponse> getHelloWord() throws IOException {
		LoadHelloWordResponse helloWordResponse = new LoadHelloWordResponse();
		try {
			helloWordResponse = retrofitService.getHelloWord();
			return new ResponseEntity<LoadHelloWordResponse>(helloWordResponse, HttpStatus.OK);
		} catch (IOException  e) {
			return new ResponseEntity<LoadHelloWordResponse>(helloWordResponse,  HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<GetExampleParameterByIdResponse> getExampleParameterById(String parameterId) throws IOException {
		GetExampleParameterByIdResponse getExampleParameterByIdResponse = retrofitService.getExampleParameterById(parameterId);
		return new ResponseEntity<GetExampleParameterByIdResponse>(getExampleParameterByIdResponse, HttpStatus.OK);
	}

}