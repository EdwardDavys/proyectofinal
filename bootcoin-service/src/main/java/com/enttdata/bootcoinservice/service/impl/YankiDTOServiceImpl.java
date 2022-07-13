package com.enttdata.bootcoinservice.service.impl;

import com.enttdata.bootcoinservice.entity.DTO.YankiDto;
import com.enttdata.bootcoinservice.service.YankiDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Service
public class YankiDTOServiceImpl implements YankiDTOService {

  @Autowired
  private WebClient.Builder client;

  private static final Logger log = LoggerFactory
      .getLogger(YankiDTOServiceImpl.class);

  @Override
  public Mono<YankiDto> findByPhoneNumber(String phoneNumber) {
    Map<String,Object> params = new HashMap<>();
    params.put("phoneNumber",phoneNumber);
    return null;//client.baseUrl("http://localhost:8087")
        //.
  }

  @Override
  public Mono<YankiDto> updateYanki(YankiDto yankiDocument) {
    return null;
  }
}
