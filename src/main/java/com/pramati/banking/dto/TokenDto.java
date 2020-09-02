package com.pramati.banking.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pramati.banking.constants.SystemConstants;
import com.pramati.banking.entity.BankService;
import com.pramati.banking.entity.ServiceType;
import com.pramati.banking.entity.TokenStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDto {

  private Integer id;
  private String email;
  private boolean existingCustomer;

  @JsonIgnore
  private Integer userId;
  private String phone;
  private String userName;
  private ServiceType serviceType;
  private String comments;
  private Set<BankService> bankServices;

  @DateTimeFormat(pattern = SystemConstants.DATE_FORMAT, iso = DateTimeFormat.ISO.DATE_TIME)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = SystemConstants.DATE_FORMAT)
  private LocalDateTime createdDate;

  private Integer counterId;
  private TokenStatus tokenStatus;


}
