package com.pramati.banking.repository;

import com.pramati.banking.entity.Counter;
import com.pramati.banking.entity.CounterServiceMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface CounterServiceRepository extends JpaRepository<CounterServiceMapping, Integer> {

  @Query("select cs.counter.id from CounterServiceMapping cs where cs.service.id in :serviceIds"
      + " and cs.deleted= false group by cs.counter.id having count(cs.counter.id)>0 ")
  List<Integer> findCounterByServiceIds(Set<Integer> serviceIds);
}

