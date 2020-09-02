package com.pramati.banking.service;

import com.pramati.banking.dto.TokenDto;
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
   * @param tokenId tokenId
   * @return TokenDto
   */
  TokenDto getToken(int tokenId);

  /**
   * Update Token Details.
   * @param tokenDto tokenDto
   * @return tokenDto
   */
  TokenDto updateToken(TokenDto tokenDto);


  /**
   * Update Token Status.
   * @param tokenDto tokenDto
   * @param tokenStatus tokenStatus
   * @return TokenDto.
   */
  TokenDto updateTokenStatus(TokenDto tokenDto, TokenStatus tokenStatus);

}
