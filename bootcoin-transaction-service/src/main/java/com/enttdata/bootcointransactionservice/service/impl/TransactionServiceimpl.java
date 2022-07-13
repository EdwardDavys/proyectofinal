package com.enttdata.bootcointransactionservice.service.impl;

import com.enttdata.bootcointransactionservice.entity.Transaction;
import com.enttdata.bootcointransactionservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionServiceimpl implements TransactionService{

  @Autowired
  private TransactionRepository repository;

  @Override
  public Mono<Transaction> create(Transaction o) {
    return repository.save(o);
  }

  @Override
  public Flux<Transaction> findAll() {
    return repository.findAll();
  }

  @Override
  public Mono<Transaction> findById(String s) {
    return repository.findById(s);
  }

  @Override
  public Mono<Transaction> update(Transaction o) {
    return repository.save(o);
  }

  @Override
  public Mono<Void> delete(Transaction o) {
    return repository.delete(o);
  }
}
