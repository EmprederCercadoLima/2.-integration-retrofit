package com.integration.retrofit.response;

import com.integration.retrofit.util.ResponseMetadaUtil;

public class LoadHelloWordResponse extends ResponseMetadaUtil {

	private ListHelloWordResponse listHelloWordResponse = new ListHelloWordResponse();
	
	public ListHelloWordResponse getListHelloWordResponse() {
		return listHelloWordResponse;
	}

	public void setListHelloWordResponse(ListHelloWordResponse listHelloWordResponse) {
		this.listHelloWordResponse = listHelloWordResponse;
	}
	
}
