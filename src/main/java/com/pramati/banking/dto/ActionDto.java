package com.pramati.banking.dto;

import com.pramati.banking.entity.BankService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionDto {

  private Integer serviceId;
  private BankService bankService;
  private String actionStatus;

}
