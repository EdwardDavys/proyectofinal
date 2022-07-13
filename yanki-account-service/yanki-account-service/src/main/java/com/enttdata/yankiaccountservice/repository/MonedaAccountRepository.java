package com.enttdata.yankiaccountservice.repository;

import com.enttdata.yankiaccountservice.entity.MonedaAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MonedaAccountRepository  extends ReactiveMongoRepository<MonedaAccount,String> {

  Flux<MonedaAccount> findByNroPhone(String nroPhone);
}
