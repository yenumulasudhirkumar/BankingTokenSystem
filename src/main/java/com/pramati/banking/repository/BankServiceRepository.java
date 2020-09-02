package com.pramati.banking.repository;

import com.pramati.banking.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankServiceRepository extends JpaRepository<Service, Integer> {

}
