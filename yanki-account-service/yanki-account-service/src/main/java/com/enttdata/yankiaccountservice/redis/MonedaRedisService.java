package com.enttdata.yankiaccountservice.redis;

import com.enttdata.yankiaccountservice.entity.DTO.Maestros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MonedaRedisService {

  public static String KEY = "MAESTRAS";

  @Autowired
  private ReactiveRedisTemplate<String, Maestros>  redisTemplate;

  public Mono<Long> put(Maestros  maestros){
    return redisTemplate.opsForList().rightPush(KEY,maestros);
  }

  public Flux<Maestros> getAll() {
    return redisTemplate.opsForList().range(KEY, 0, -1);
  }
}
