package com.integration.retrofit.config;

import java.net.MalformedURLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.integration.retrofit.repository.RetrofitInterface;
import com.integration.retrofit.repository.InitialConfigurationInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitClientToIntegrationSwaggerConfig {
	private static final String INTEGRATION_SWAGGER_HOST ="localhost";
	private static final int INTEGRATION_SWAGGER_PORT= 8080;
	private static final String INTEGRATION_SWAGGER_PATH_BASE="/v1/";

	 private static final String INITIAL_CONFIGURATION_HOST ="localhost";
	  private static final int INITIAL_CONFIGURATION_PORT= 8091;
	  private static final String INITIAL_CONFIGURATION_PATH_BASE="/integration-configuration/v3/";
	  
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
      System.out.println("InitialConfigurationInterface uriComponents.toUriString()" + uriComponents.toUriString());
        Retrofit retrofit = new Retrofit.Builder()
        		.baseUrl(uriComponents.toUriString())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        
        RetrofitInterface service = retrofit.create(RetrofitInterface.class);
        
        return  service;
    }
    
    @Bean
    InitialConfigurationInterface getRetrofitClientToInitialConfiguration() throws MalformedURLException {
            UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host(INITIAL_CONFIGURATION_HOST)
                .port(INITIAL_CONFIGURATION_PORT)
                .path(INITIAL_CONFIGURATION_PATH_BASE)
                .build()
                .encode();
        
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        System.out.println("InitialConfigurationInterface uriComponents.toUriString()" + uriComponents.toUriString());
          Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(uriComponents.toUriString())
                  .addConverterFactory(GsonConverterFactory.create(gson))
                  .build();
          
          InitialConfigurationInterface service = retrofit.create(InitialConfigurationInterface.class);
          
          return  service;
    }
}
