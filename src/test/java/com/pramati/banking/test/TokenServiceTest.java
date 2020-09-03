package com.pramati.banking.test;

import com.pramati.banking.converter.TokenConverter;
import com.pramati.banking.converter.UserConverter;
import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.ServiceType;
import com.pramati.banking.repository.TokenRepository;
import com.pramati.banking.repository.UserRepository;
import com.pramati.banking.service.TokenService;
import com.pramati.banking.service.impl.BankServiceImpl;
import com.pramati.banking.service.impl.CounterServiceImpl;
import com.pramati.banking.service.impl.CustomerServiceImpl;
import com.pramati.banking.service.impl.TokenServiceImpl;
import com.pramati.banking.service.impl.UserServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class TokenServiceTest extends AbstractTest {

  @InjectMocks
  TokenServiceImpl tokenService;


  @Mock
  TokenRepository tokenRepository;

  @Mock
  TokenConverter tokenConverter;


  @InjectMocks
  CounterServiceImpl counterService;

  @Test
  public void generateToken() {

    TokenDto tokenDto = TokenDto.builder().email("customer1@gmail.com")
        .phone("8088123123").serviceType(ServiceType.REGULAR).userName("customer1").build();

    tokenService.generateToken(tokenDto);
    verify(tokenRepository, times(1)).save(tokenConverter.buildEntityFromDto(tokenDto));

  }







}
