package com.enttdata.yankiaccountservice.service;

import com.enttdata.yankiaccountservice.entity.MonedaAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonedaAccountService {

  Mono<MonedaAccount> create(MonedaAccount m);

  Flux<MonedaAccount> findAll();

  Mono<MonedaAccount> findById(String id);

  Flux<MonedaAccount> findByNroPhone(String nroPhone);

  Mono<MonedaAccount> update(MonedaAccount m);

  Mono<Boolean> delete(String id);

}
