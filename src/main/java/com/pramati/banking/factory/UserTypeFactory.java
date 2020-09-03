package com.pramati.banking.factory;

import com.pramati.banking.entity.UserRole;
import com.pramati.banking.exception.UserException;
import com.pramati.banking.service.UserService;
import com.pramati.banking.service.impl.CustomerServiceImpl;
import com.pramati.banking.service.impl.EmployeeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserTypeFactory {

  private final CustomerServiceImpl customerService;
  private final EmployeeServiceImpl employeeService;

  /**
   * Factory Method to get User Service based on UserType.
   * @param userRole userType
   * @return UserService
   * @throws UserException UserException
   */
  public UserService getUser(UserRole userRole) {

    switch (userRole) {

      case EMPLOYEE:
        return employeeService; // Not implemented since this not part of requirement.

      case CUSTOMER:
        return customerService;

      default:
        break;

    }

    throw new UserException("Please provide valid userType");
  }


}
