package com.enttdata.yankiaccountservice.service.impl;

import com.enttdata.yankiaccountservice.entity.MonedaAccount;
import com.enttdata.yankiaccountservice.repository.MonedaAccountRepository;
import com.enttdata.yankiaccountservice.service.MonedaAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class MonedaAccountServiceImpl implements MonedaAccountService {

  @Autowired
  MonedaAccountRepository repository;


  @Override
  public Mono<MonedaAccount> create(MonedaAccount m) {
    log.info("Agregando cuenta");
    return repository.save(m);
  }

  @Override
  public Flux<MonedaAccount> findAll() {
    log.info("Listar Cuentas");
    return null;
  }

  @Override
  public Mono<MonedaAccount> findById(String id) {
    log.info("Buscar cuenta por Id");
    return repository.findById(id);
  }

  @Override
  public Flux<MonedaAccount> findByNroPhone(String nroPhone) {
    log.info("Buscar cuenta por numero de celular");
    return repository.findByNroPhone(nroPhone);
  }

  @Override
  public Mono<MonedaAccount> update(MonedaAccount m) {
    return repository.save(m);
  }

  @Override
  public Mono<Boolean> delete(String id) {
    return repository.findById(id)
        .flatMap(moneda -> repository.delete(moneda).then(Mono.just(Boolean.TRUE))
            .defaultIfEmpty(Boolean.FALSE));
  }
}
