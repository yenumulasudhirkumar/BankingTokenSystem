package com.pramati.banking.converter;

import com.pramati.banking.dto.CustomerDto;
import com.pramati.banking.dto.UserDto;
import com.pramati.banking.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {


  /**
   * Converter method to build entity from Dto.
   * @param userDto userDto
   * @return Customer.
   */
  public Customer buildEntityFromDto(UserDto userDto) {

    return Customer.builder().accountNumber(userDto.getCustomerDto().getAccountNumber())
        .deleted(false)
        .existingCustomer(userDto.getCustomerDto().isExistingCustomer())
        .serviceType(userDto.getCustomerDto().getServiceType())
        .build();
  }

  /**
   * Converter method to build dto from entity.
   * @param customer customer
   * @return userDto.
   */
  public CustomerDto buildDtoFromEntity(Customer customer) {
    return CustomerDto.builder().serviceType(customer.getServiceType()).existingCustomer(customer.isExistingCustomer())
        .accountNumber(customer.getAccountNumber()).build();
  }

}
