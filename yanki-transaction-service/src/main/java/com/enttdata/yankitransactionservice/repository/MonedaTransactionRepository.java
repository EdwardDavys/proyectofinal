package com.enttdata.yankitransactionservice.repository;

import com.enttdata.yankitransactionservice.entity.MonedaTransaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MonedaTransactionRepository extends ReactiveMongoRepository<MonedaTransaction,String> {
}
