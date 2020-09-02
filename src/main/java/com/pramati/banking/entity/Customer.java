package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "uuid2")
  private Integer id;

  @Column(name = "existing_customer")
  private boolean existingCustomer;

  @Column(name = "account_no")
  private String accountNumber;


  @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
  private User user;

  @Column(name = "is_deleted")
  private Boolean deleted;

  @Column(name = "service_type")
  @Enumerated(EnumType.STRING)
  private  ServiceType serviceType;


}
