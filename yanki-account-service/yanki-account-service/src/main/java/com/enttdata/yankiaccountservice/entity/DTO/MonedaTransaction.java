package com.enttdata.yankiaccountservice.entity.DTO;

import com.enttdata.yankiaccountservice.entity.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonedaTransaction {

  private String id;

  private String originNumber;

  private String destinationNumber;

  private Double amount;

  private Status status;

  private int condition;

  private LocalDateTime createAt;
}
