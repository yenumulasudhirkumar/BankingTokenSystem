package com.pramati.banking.test;

import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenStatus;
import com.pramati.banking.repository.CounterRepository;
import com.pramati.banking.repository.TokenRepository;
import com.pramati.banking.service.impl.CounterServiceImpl;
import com.pramati.banking.service.impl.TokenServiceImpl;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CounterServiceTest extends AbstractTest {

  @InjectMocks
  private CounterServiceImpl counterService;

  @Mock
  CounterRepository counterRepository;

  @InjectMocks
  private TokenRepository tokenRepository;

  @InjectMocks
  private TokenServiceImpl tokenService;


  @Test
  public void getAllCounters() {
    counterService.getAllCounters();
    verify(counterRepository, times(1)).findAll();
  }

  @Test
  public void processNextCustomer() {
    counterService.processNextCustomer(1);
    Token token = tokenService.getNextTokenForProcessing(1);
    token.setTokenStatus(TokenStatus.COMPLETED);
    verify(tokenRepository, times(1)).save(token);
  }

}
