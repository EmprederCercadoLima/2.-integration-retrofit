package com.integration.retrofit.response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class GetExampleParameterByIdResponse {
	
	private String id;
	private String email;
	private String password;
	
}
