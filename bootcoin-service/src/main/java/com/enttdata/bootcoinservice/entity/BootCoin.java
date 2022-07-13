package com.enttdata.bootcoinservice.entity;

import com.enttdata.bootcoinservice.entity.DTO.Yanki;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "bootcoins")
public class BootCoin {

  @Id
  private String id;

  private String name;

  private String customerIdentityType;

  private String customerIdentityNumber;

  private String phoneNumber;

  private String email;

  private Yanki yanki;

  private String typeOfAccount;

  private Double amount;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss ")
  private LocalDateTime createdAt = LocalDateTime.now();

}
