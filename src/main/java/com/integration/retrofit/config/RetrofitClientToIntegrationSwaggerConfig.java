package com.integration.retrofit.config;

import java.net.MalformedURLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.integration.retrofit.repository.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitClientToIntegrationSwaggerConfig {
	private static final String INTEGRATION_SWAGGER_HOST ="localhost";
	private static final int INTEGRATION_SWAGGER_PORT= 8080;
	private static final String INTEGRATION_SWAGGER_PATH_BASE="/v1/hello-word/";

    @Bean
    RetrofitInterface getRetrofitClientToIntegrationSwagger() throws MalformedURLException {
    	
    	 UriComponents uriComponents = UriComponentsBuilder.newInstance()
    		      .scheme("http")
    		      .host(INTEGRATION_SWAGGER_HOST)
    		      .port(INTEGRATION_SWAGGER_PORT)
    		      .path(INTEGRATION_SWAGGER_PATH_BASE)
    		      .build()
    		      .encode();
    	
    	Gson gson = new GsonBuilder()
    	        .setLenient()
    	        .create();
    	
        Retrofit retrofit = new Retrofit.Builder()
        		.baseUrl(uriComponents.toUriString())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        
        return  service;
    }
}
