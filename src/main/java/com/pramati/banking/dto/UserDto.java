package com.pramati.banking.dto;

import com.pramati.banking.entity.UserRole;
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
public class UserDto implements Serializable {

  private Integer id;
  private String name;
  private String email;
  private String phone;
  private UserRole userRole;
  private String branchName;
  private String dob;
  private String gender;
  private String address;
  private CustomerDto customerDto;
  private EmployeeDto employeeDto;

}
