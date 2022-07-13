package com.enttdata.yankiaccountservice.controller;

import com.enttdata.yankiaccountservice.entity.DTO.Maestros;
import com.enttdata.yankiaccountservice.entity.MonedaAccount;
import com.enttdata.yankiaccountservice.redis.MonedaRedisService;
import com.enttdata.yankiaccountservice.service.MonedaAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/yanki")
public class MonedaAccountController {

  @Autowired
  MonedaAccountService service;

  @Autowired
  MonedaRedisService redisService;

  @GetMapping("/list")
  public Flux<MonedaAccount> finAll() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public Mono<MonedaAccount> findById(@PathVariable String id) {
    return service.findById(id);
  }

  @GetMapping("/phone/{number}")
  public Mono<MonedaAccount> findByNroPhone(@PathVariable String number) {
    return service.findByNroPhone(number).next();
  }

  @PostMapping("/create")
  public Mono<ResponseEntity<MonedaAccount>> create(
      @RequestBody MonedaAccount monedaAccount) {
    log.info("Buscando ....");
    return service.findByNroPhone(monedaAccount.getNroPhone()).collectList()
        .flatMap(c -> {
          if (c.isEmpty()) {
            log.info("Enviando nueva cuenta");
            monedaAccount.setCreateAt(LocalDateTime.now());
            return service.create(monedaAccount);
          } else {
            log.info("ya existe un nuemro con esa cuenta cuenta");
            return Mono.empty();
          }
        })
        .map(savedCustomer -> new ResponseEntity<>(savedCustomer,
            HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PutMapping("/update")
  public Mono<ResponseEntity<MonedaAccount>> update(
      @RequestBody MonedaAccount monedaAccount) {
    log.info("buscando tarjeta de credito");
    return service.findById(monedaAccount.getId()).flatMap(cc -> {
          cc.setBalance(monedaAccount.getBalance());
          cc.setEmail(monedaAccount.getEmail());
          cc.setImeiPhone(monedaAccount.getImeiPhone());
          cc.setNroDocument(monedaAccount.getNroDocument());
          cc.setNroPhone(monedaAccount.getNroPhone());
          cc.setPhoneOperator(monedaAccount.getPhoneOperator());
          cc.setTypeDocument(monedaAccount.getTypeDocument());
          return service.update(cc);
        }).map(cc -> new ResponseEntity<>(cc, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @DeleteMapping("/delete/{id}")
  public Mono<ResponseEntity<String>> delete(@PathVariable String id) {
    log.info("eliminando ....");
    return service.delete(id).filter(da -> da)
        .map(da -> new ResponseEntity<>("Account Deleted", HttpStatus.ACCEPTED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping("/redis")
  public Mono<ResponseEntity<Long>> putRedis(Maestros maestros) {
    log.info("Agregando a RedisDB");
    return redisService.put(maestros)
        .map(m -> new ResponseEntity<>(m, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @GetMapping("/redis")
  public Flux<ResponseEntity<Maestros>> getRedisAll(Maestros maestros) {
    log.info("Listar RedisDB");
    return redisService.getAll()
        .map(m -> new ResponseEntity<>(m, HttpStatus.CREATED))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
}
