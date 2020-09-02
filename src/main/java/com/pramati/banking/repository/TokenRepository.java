package com.pramati.banking.repository;

import com.pramati.banking.entity.Token;
import com.pramati.banking.entity.TokenStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {



  @Query("SELECT t from Token t where t.tokenStatus = :tokenStatus and"
      + " t.deleted = false and t.counter.id = :counterId and not t.tokenStatus ='COMPLETED' order by t.audit.createdOn")
  List<Token> findByTokenStatusAndCounter_Id(TokenStatus tokenStatus, Integer counterId);

}
