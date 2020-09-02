package com.pramati.banking.converter;

import com.pramati.banking.dto.TokenDto;
import com.pramati.banking.entity.Counter;
import com.pramati.banking.entity.Customer;
import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.User;
import com.pramati.banking.entity.UserRole;
import org.springframework.stereotype.Component;

@Component
public class TokenConverter {


  /**
   * Converter method to convert from TokenDto to Token.
   * @param tokenDto tokenDto.
   * @return Token.
   */
  public Token buildEntityFromDto(TokenDto tokenDto) {

    User user = User.builder().userRole(UserRole.CUSTOMER).phone(tokenDto.getPhone())
        .name(tokenDto.getUserName())
        .email(tokenDto.getEmail()).id(tokenDto.getUserId()).deleted(false).build();
    Customer c = Customer.builder().serviceType(tokenDto.getServiceType()).existingCustomer(tokenDto.isExistingCustomer())
        .user(user).deleted(false).build();
    user.setCustomer(c);

    return Token.builder().serviceType(tokenDto.getServiceType())
        .counter(Counter.builder().id(tokenDto.getCounterId()).build())
    .deleted(false).user(user).comments(tokenDto.getComments()).tokenStatus(tokenDto.getTokenStatus()).build();
  }

  public TokenDto buildDtoFromEntity(Token token) {


    return TokenDto.builder().id(token.getId()).comments(token.getComments()).counterId(token.getCounter().getId())
    .createdDate(token.getAudit().getCreatedOn()).userId(token.getUser().getId()).email(token.getUser().getEmail())
        .phone(token.getUser().getPhone()).serviceType(token.getServiceType()).tokenStatus(token.getTokenStatus())
        .userName(token.getUser().getName()).build();
  }

}
