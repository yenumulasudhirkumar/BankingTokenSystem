package com.pramati.banking.service;

import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.Counter;
import com.pramati.banking.entity.ServiceType;
import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenStatus;

public interface TokenService {

  /**
   * Generate Token for the Service Request.
   * @param tokenDto tokenDto.
   * @return TokenDto.
   */
  TokenDto generateToken(TokenDto tokenDto);


  /**
   * Retrieve Token details based on TokenId.
   * @return TokenDto
   */
  Token getNextTokenForProcessing(Integer counterId);

  /**
   * Update Token Details.
   * @param tokenDto tokenDto
   * @return tokenDto
   */
  TokenDto updateToken(TokenDto tokenDto);


  /**
   * Update Token Status.
   * @param tokenId tokenId
   * @param tokenStatus tokenStatus
   */
  void updateTokenStatus(Integer tokenId, TokenStatus tokenStatus);

}
