package com.pramati.banking.factory;

import com.pramati.banking.entity.UserRole;
import com.pramati.banking.exception.UserException;
import com.pramati.banking.service.UserService;
import com.pramati.banking.service.impl.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTypeFactory {

  private final CustomerServiceImpl customerService;

  /**
   * Factory Method to get User Service based on UserType.
   * @param userRole userType
   * @return UserService
   * @throws UserException UserException
   */
  public UserService getUser(UserRole userRole) {

    switch (userRole) {
      case CUSTOMER:
        return customerService;

      default:
        break;

    }

    throw new UserException("Please provide valid userType");
  }


}
