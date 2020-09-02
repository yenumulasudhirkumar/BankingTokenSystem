package com.pramati.banking.dto;

import com.pramati.banking.entity.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class CustomerDto implements Serializable {

  private int customerId;
  private boolean existingCustomer;
  private String accountNumber;
  private ServiceType serviceType;

}
