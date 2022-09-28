package com.integration.retrofit.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.retrofit.business.InitialConfigurationBusinessInterface;
import com.integration.retrofit.business.RetrofitBusinessInterface;
import com.integration.retrofit.response.GetExampleParameterByIdResponse;
import com.integration.retrofit.response.LoadHelloWordResponse;

@RestController
@RequestMapping("/v1")
public class RetrofitController {

	@Autowired
	private RetrofitBusinessInterface retrofitBusinessInterface;
	
	@Autowired
	private InitialConfigurationBusinessInterface initialConfigurationBusinessInterface;
	
	@GetMapping("/channel/http/hello-word")
	public ResponseEntity<LoadHelloWordResponse> getHelloWord() throws IOException {
		return retrofitBusinessInterface.getHelloWord();
	}
	
	@GetMapping("channel/http/{parameterId}")
	public ResponseEntity<GetExampleParameterByIdResponse> getExampleParameterById(
			@PathVariable (required = true, name="parameterId") String parameterId
		) throws IOException {
		return retrofitBusinessInterface.getExampleParameterById(parameterId);
	}
	
	 @GetMapping("/initial-configuration/hello-word")
	  public String getHelloWordInitialConfigiuration() throws IOException {
	    return initialConfigurationBusinessInterface.getHelloWord();
	 }
	 
}
