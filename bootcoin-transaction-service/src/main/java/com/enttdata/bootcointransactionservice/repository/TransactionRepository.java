package com.enttdata.bootcointransactionservice.repository;

import com.enttdata.bootcointransactionservice.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TransactionRepository extends ReactiveMongoRepository<Transaction, String> {
}
