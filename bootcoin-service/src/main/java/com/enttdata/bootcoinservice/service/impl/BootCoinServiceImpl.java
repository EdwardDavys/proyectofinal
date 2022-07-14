package com.enttdata.bootcoinservice.service.impl;


import com.enttdata.bootcoinservice.entity.BootCoin;
import com.enttdata.bootcoinservice.repository.BootCoinRepository;
import com.enttdata.bootcoinservice.service.BootCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BootCoinServiceImpl implements BootCoinService {

  private static final Logger log = LoggerFactory
      .getLogger(BootCoinServiceImpl.class);

  private static final double COMPRA = 3.98;
  private static final double VENTA = 3.89;

  @Autowired
  private BootCoinRepository repository;

  @Override
  public Mono<BootCoin> createBootCoin(BootCoin bootCoinDocument) {
    return ;
  }

  @Override
  public Mono<BootCoin> updateBootCoin(String id, BootCoin bootCoinDocument) {
    return null;
  }

  @Override
  public Mono<BootCoin> findByPhoneNumber(String phoneNumber) {
    return null;
  }

  @Override
  public Mono<BootCoin> buyBootCoin(BootCoin bootCoin) {
    return null;
  }
}
