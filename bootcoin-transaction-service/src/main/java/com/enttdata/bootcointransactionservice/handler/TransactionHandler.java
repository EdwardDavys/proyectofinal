package com.enttdata.bootcointransactionservice.handler;

import com.enttdata.bootcointransactionservice.entity.Transaction;
import com.enttdata.bootcointransactionservice.service.impl.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TransactionHandler {

  @Autowired
  private TransactionService service;

  private static final Logger log = LoggerFactory.getLogger(Transaction.class);

  public Mono<ServerResponse> createTransaction(ServerRequest request){
    Mono<Transaction> transactionMono = request.bodyToMono(Transaction.class);

    return transactionMono.flatMap(transaction -> service.create(transaction))
        .flatMap(
            t->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(t)))
                .switchIfEmpty(ServerResponse.badRequest().build());
  }

  public Mono<ServerResponse> findAll(ServerRequest request) {
    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
        .body(service.findAll(), Transaction.class);
  }

  public Mono<ServerResponse> delete(ServerRequest request) {
    String id = request.pathVariable("id");
    Mono<Transaction> accountMono = service.findById(id);
    return accountMono
        .doOnNext(c -> log.info("Delete BootCoin Transaction", c.getId()))
        .flatMap(
            c -> service.delete(c).then(ServerResponse.noContent().build()))
        .switchIfEmpty(ServerResponse.notFound().build());
  }
}
