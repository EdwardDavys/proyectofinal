package com.enttdata.bootcoinservice.service;

import com.enttdata.bootcoinservice.entity.BootCoin;
import reactor.core.publisher.Mono;

public interface BootCoinService {

  Mono<BootCoin> createBootCoin(BootCoin bootCoinDocument);

  Mono<BootCoin> updateBootCoin(String id, BootCoin bootCoinDocument);

  Mono<BootCoin> findByPhoneNumber(String phoneNumber);

  Mono<BootCoin> buyBootCoin(BootCoin bootCoin);
}
