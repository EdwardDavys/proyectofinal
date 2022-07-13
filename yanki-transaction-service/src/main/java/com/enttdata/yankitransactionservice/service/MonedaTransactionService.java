package com.enttdata.yankitransactionservice.service;

import com.enttdata.yankitransactionservice.entity.MonedaTransaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MonedaTransactionService {

  Flux<MonedaTransaction> findAll();

  Mono<MonedaTransaction> findById(String id);

  Mono<MonedaTransaction> create(MonedaTransaction monedaTransaction);

}
