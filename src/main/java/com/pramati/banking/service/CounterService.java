package com.pramati.banking.service;

import com.pramati.banking.entity.BankService;

import java.util.Set;

public interface CounterService {

  Integer getCounterForTokenServices(Set<BankService> bankServices);
}
