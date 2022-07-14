package com.enttdata.yankitransactionservice.controller;

import com.enttdata.yankitransactionservice.entity.MonedaTransaction;
import com.enttdata.yankitransactionservice.service.MonedaTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RestController
@RequestMapping("publish")
public class MonedaTransactionController {

  @Autowired
  private MonedaTransactionService service;

  @GetMapping("list")
  public Flux<MonedaTransaction> finAll(){
    return service.findAll();
  }

  @PostMapping("/create")
  public Mono<ResponseEntity<MonedaTransaction>> create(@RequestBody MonedaTransaction monedaTransaction){
    monedaTransaction.setCreateAt(LocalDateTime.now());
    return service.create(monedaTransaction)
        .map(mt -> new ResponseEntity<>(mt, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
  }

}
