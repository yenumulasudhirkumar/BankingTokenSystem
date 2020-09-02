package com.pramati.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.pramati.banking")
public class BankingTokenSystem {

  public static void main(String[] args) {
    SpringApplication.run(BankingTokenSystem.class, args);
  }

}
