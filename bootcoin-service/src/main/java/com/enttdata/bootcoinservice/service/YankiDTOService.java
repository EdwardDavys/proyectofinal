package com.enttdata.bootcoinservice.service;

import com.enttdata.bootcoinservice.entity.DTO.YankiDto;
import reactor.core.publisher.Mono;

public interface YankiDTOService {

  Mono<YankiDto> findByPhoneNumber(String customerIdentityNumber);

  Mono<YankiDto> updateYanki(YankiDto yankiDocument);
}
