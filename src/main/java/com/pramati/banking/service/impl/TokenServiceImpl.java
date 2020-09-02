package com.pramati.banking.service.impl;

import com.pramati.banking.converter.TokenConverter;
import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.Counter;
import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenServiceMapping;
import com.pramati.banking.entity.TokenStatus;
import com.pramati.banking.exception.TokenException;
import com.pramati.banking.repository.TokenRepository;
import com.pramati.banking.service.CounterService;
import com.pramati.banking.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {



  @Autowired
  private  CounterService counterService;
  private final TokenRepository tokenRepository;
  private final TokenConverter tokenConverter;
  private final BankServiceImpl bankService;



  /**
   * Generate Token for the Service Request.
   *
   * @param tokenDto tokenDto.
   * @return TokenDto.
   */
  @Override
  @Transactional
  public TokenDto generateToken(TokenDto tokenDto) {

    checkValidity(tokenDto);
    tokenDto.setTokenStatus(TokenStatus.GENERATED);
    tokenDto.setCounterId(counterService.getCounterForTokenServices(tokenDto.getBankServices()));
    Token token = tokenConverter.buildEntityFromDto(tokenDto);

    List<com.pramati.banking.entity.Service> services = bankService.getAllBankServices();
    Set<com.pramati.banking.entity.Service> tokenServices = services.stream().filter(service -> tokenDto.getBankServices().toString()
        .contains(service.getServiceName())).collect(Collectors.toSet());
    token.setTokenServiceMappings(tokenServices.stream().map(service -> TokenServiceMapping.builder().token(token)
        .counter(Counter.builder().id(token.getCounter().getId()).build()).service(service).build())
        .collect(Collectors.toSet()));
    return tokenConverter.buildDtoFromEntity(tokenRepository.save(token));

  }



  /**
   * Retrieve Token details based on TokenId.
   *
   * @return TokenDto
   */
  @Override
  public Token getNextTokenForProcessing(Integer counterId) {

    List<Token> tokenList = tokenRepository.findByTokenStatusAndCounter_Id(TokenStatus.GENERATED,counterId);
    if (tokenList.size() == 0) {
      throw new TokenException("No new csutomers available");
    } else {
      return tokenList.get(0);
    }
  }

  public Token saveToken(Token token) {
    return tokenRepository.save(token);
  }


  /**
   * Update Token Details.
   *
   * @param tokenDto tokenDto
   * @return tokenDto
   */
  @Override
  public TokenDto updateToken(TokenDto tokenDto) {
    return null;
  }

  /**
   * Update Token Status.
   *
   * @param tokenId tokenId
   * @param tokenStatus tokenStatus
   */
  @Override
  public void updateTokenStatus(Integer tokenId, TokenStatus tokenStatus) {

    Token token = tokenRepository.findById(tokenId)
        .orElseThrow(() -> new TokenException("Please provide valid token Id"));
    token.setTokenStatus(tokenStatus);
    tokenRepository.save(token);
  }


  private void checkValidity(TokenDto tokenDto) {

    if (tokenDto == null) {
      throw new TokenException("Please provide valid tokenDto");
    }

    if (tokenDto.getEmail() == null) {
      throw new TokenException(" Please provide valid User Email");
    }

    if (tokenDto.getPhone() == null) {
      throw new TokenException("Please provide valid User Phone");
    }

    if (tokenDto.getServiceType() == null) {
      throw new TokenException("Please select valid ServiceType");
    }

    if (tokenDto.getBankServices().size() == 0) {
      throw new TokenException("Please select atleast one bank service");
    }

  }
}
