package com.enttdata.bootcointransactionservice.config;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.enttdata.bootcointransactionservice.handler.TransactionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

  @Bean
  public RouterFunction<ServerResponse> routes(TransactionHandler transactionHandler){
    return route(POST("/bootcoin-transaction"),transactionHandler::createTransaction)
        .andRoute(GET("bootcoin-transaction"),transactionHandler::findAll)
        .andRoute(DELETE("bootcoin-transaction"),transactionHandler::delete);
  }
}
