package com.pramati.banking.repository;

import com.pramati.banking.entity.TokenServiceMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TokenServiceRepository extends JpaRepository<TokenServiceMapping, Integer> {

  @Query("select distinct tsm.token.id from TokenServiceMapping tsm where tsm.counter.id = :counterId ")
  List<Integer> findDistinctByCounter(int counterId);

}
