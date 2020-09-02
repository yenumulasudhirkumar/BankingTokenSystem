package com.pramati.banking.service.impl;

import com.pramati.banking.repository.BankServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankServiceImpl {

  private final BankServiceRepository bankServiceRepository;

  public List<com.pramati.banking.entity.Service> getAllBankServices() {
    return bankServiceRepository.findAll();
  }

}
