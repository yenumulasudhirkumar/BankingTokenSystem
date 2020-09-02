package com.pramati.banking.service.impl;

import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.Customer;
import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenStatus;
import com.pramati.banking.entity.User;
import com.pramati.banking.repository.TokenRepository;
import com.pramati.banking.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.SequenceGenerator;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

  private final TokenRepository tokenRepository;
  private final UserServiceImpl userService;
  private final SequenceGenerator sequenceGenerator;

  /**
   * Generate Token for the Service Request.
   *
   * @param tokenDto tokenDto.
   * @return TokenDto.
   */
  @Override
  public TokenDto generateToken(TokenDto tokenDto) {

    if (tokenDto.getEmail() != null || !userService.findByEmail(tokenDto.getEmail())) {
      Customer customer = userService.createCustomer(tokenDto);
      tokenDto.setCustomer(customer);
      tokenDto.setCustomerId(customer.getCustomerId());
    }
    try {
      if(!branchRepository.isBranchExists(token.getBranchName())) {
        throw new BranchNotExistsException("No branch exist with branchName:"+token.getBranchName());
      }
      Token createdToken = tokenRepository.createToken(token);

      return counterManager.assignTokenToCounter(createdToken);
    } catch(Exception e) {
      throw new TokenException("Unable to create or assign Token"+e.getMessage(), e);
    }
  }

  /**
   * Retrieve Token details based on TokenId.
   *
   * @param tokenId tokenId
   * @return TokenDto
   */
  @Override
  public TokenDto getToken(int tokenId) {
    return null;
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
   * @param tokenDto    tokenDto
   * @param tokenStatus tokenStatus
   * @return TokenDto.
   */
  @Override
  public TokenDto updateTokenStatus(TokenDto tokenDto, TokenStatus tokenStatus) {
    return null;
  }
}
