package com.pramati.banking.dto;

import com.pramati.banking.entity.BankService;
import com.pramati.banking.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CounterDto {

  private Integer counterId;
  private String counterServiceType;
  private String currentTokenId;
  private Set<BankService> counterBankServices;
  private int queueSize;
  private List<Integer> tokenIdsList;

}
