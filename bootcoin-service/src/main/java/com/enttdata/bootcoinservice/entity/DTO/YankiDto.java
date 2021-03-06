package com.enttdata.bootcoinservice.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class YankiDto {

  private String id;
  private String ownerName;
  private String phoneNumber;
  private Double amount;

}
