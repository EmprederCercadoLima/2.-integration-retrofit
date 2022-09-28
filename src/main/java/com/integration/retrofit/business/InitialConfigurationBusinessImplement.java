package com.integration.retrofit.business;

import com.integration.retrofit.repository.InitialConfigurationService;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InitialConfigurationBusinessImplement implements InitialConfigurationBusinessInterface {
  
  @Autowired
  private InitialConfigurationService initialConfigurationService;

  public String getHelloWord() throws IOException {
    return initialConfigurationService.getHelloWord();
  }

}
