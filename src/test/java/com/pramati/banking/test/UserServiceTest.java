package com.pramati.banking.test;

import com.pramati.banking.converter.UserConverter;
import com.pramati.banking.dto.CustomerDto;
import com.pramati.banking.dto.UserDto;
import com.pramati.banking.entity.ServiceType;
import com.pramati.banking.entity.UserRole;
import com.pramati.banking.repository.UserRepository;
import com.pramati.banking.service.impl.UserServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserServiceTest extends AbstractTest{

  @InjectMocks
  UserServiceImpl userService;

  @Mock
  UserRepository userRepository;

  @Mock
  UserConverter userConverter;

  @Before
  public void init() {
    MockitoAnnotations.initMocks(this);
  }


  @Test
  public  void createUser() {

    UserDto userDto =UserDto.builder().address("Hyderabad, Telanagan").dob("1945-02-01").email("customer1@gmail.com")
        .gender("Male").name("customer1").phone("89123121213").userRole(UserRole.CUSTOMER)
        .customerDto(CustomerDto.builder().existingCustomer(false).serviceType(ServiceType.REGULAR)
            .build()).build();

    userService.createUser(userDto);

    verify(userRepository, times(1)).save(userConverter.buildEntityFromDto(userDto));

  }





}

