package com.pramati.banking.repository;

import com.pramati.banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

  @Query("select c from Customer c where c.user.id =:userId and c.deleted = false ")
  Customer findByUser(int userId);
}
