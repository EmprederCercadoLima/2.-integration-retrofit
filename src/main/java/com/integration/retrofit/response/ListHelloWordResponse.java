package com.integration.retrofit.response;

import java.util.List;

public class ListHelloWordResponse {
	
	private List<HelloWordResponse> helloWordResponse;

	public List<HelloWordResponse> getHelloWordResponse() {
		return helloWordResponse;
	}

	public void setHelloWordResponse(List<HelloWordResponse> helloWordResponse) {
		this.helloWordResponse = helloWordResponse;
	}
}
