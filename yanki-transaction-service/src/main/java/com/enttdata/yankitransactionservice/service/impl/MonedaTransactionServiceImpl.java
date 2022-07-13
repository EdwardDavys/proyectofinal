package com.enttdata.yankitransactionservice.service.impl;

import com.enttdata.yankitransactionservice.entity.MonedaTransaction;
import com.enttdata.yankitransactionservice.repository.MonedaTransactionRepository;
import com.enttdata.yankitransactionservice.service.MonedaTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MonedaTransactionServiceImpl implements MonedaTransactionService {

  @Autowired
  MonedaTransactionRepository repository;


  @Override
  public Flux<MonedaTransaction> findAll() {
    log.info("Listar");
    return repository.findAll();
  }

  @Override
  public Mono<MonedaTransaction> findById(String id) {
    log.info("Buscar or Id");
    return repository.findById(id);
  }

  @Override
  public Mono<MonedaTransaction> create(MonedaTransaction monedaTransaction) {
    log.info("Guardar Transaccion");
    return repository.save(monedaTransaction);
  }
}
