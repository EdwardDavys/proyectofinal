package com.enttdata.bootcoinservice.repository;

import com.enttdata.bootcoinservice.entity.BootCoin;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface BootCoinRepository extends ReactiveMongoRepository<BootCoin,String> {

  Mono<BootCoin> findByPhoneNumber(String customercustomerIdentityNumber);

}
