package com.pramati.banking.converter;

import com.pramati.banking.dto.UserDto;
import com.pramati.banking.entity.Customer;
import com.pramati.banking.entity.User;
import com.pramati.banking.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserConverter {

  private final CustomerConverter customerConverter;

  /**
   * Converter to build user from userDto.
   * @param userDto userDto
   * @return User
   */
  public User buildEntityFromDto(UserDto userDto) {

    User user = User.builder().id(userDto.getId()).branchName(userDto.getBranchName())
        .deleted(false).email(userDto.getEmail())
        .address(userDto.getAddress()).name(userDto
        .getName()).phone(userDto.getPhone()).userRole(userDto.getUserRole()).build();
    if (userDto.getUserRole().equals(UserRole.CUSTOMER)) {

      user.setCustomer(Customer.builder().accountNumber(userDto.getCustomerDto().getAccountNumber())
          .deleted(false).existingCustomer(userDto.getCustomerDto().isExistingCustomer()).user(user)
          .serviceType(userDto.getCustomerDto().getServiceType()).build());
    }

    return user;



  }

  public UserDto buildDtoFromEntity(User user) {
    return UserDto.builder().address(user.getAddress()).dob(user.getDob()).email(user.getEmail())
        .gender(user.getGender()).id(user.getId()).name(user.getName()).branchName(user.getBranchName())
        .phone(user.getPhone()).userRole(user.getUserRole())
        .customerDto(customerConverter.buildDtoFromEntity(user.getCustomer())).build();
  }
}
