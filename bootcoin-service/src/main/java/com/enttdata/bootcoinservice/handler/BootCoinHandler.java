package com.enttdata.bootcoinservice.handler;

import com.enttdata.bootcoinservice.service.BootCoinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BootCoinHandler {

  private static final Logger log = LoggerFactory
      .getLogger(BootCoinHandler.class);

  @Autowired
  private BootCoinService bootCoinService;
}
