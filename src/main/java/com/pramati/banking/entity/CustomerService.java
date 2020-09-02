package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer_service")
public class CustomerService implements Serializable {

  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "uuid2")
  private Integer id;

  @Column(name = "service_name")
  private String serviceName;

  @Column(name = "is_deleted")
  private Boolean deleted;


}
