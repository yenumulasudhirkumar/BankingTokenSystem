package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "token_service_mapping")
public class TokenServiceMapping implements Serializable {

  @Id
  @Column(name = "id")
  @SequenceGenerator(name = "token_service_seq", sequenceName = "Token_Service_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_service_seq")
  private Integer id;

  @ManyToOne
  private Service service;

  @ManyToOne
  private Token token;

  @ManyToOne
  private Counter counter;

  @Column(name = "token_service_status")
  @Size(max = 20)
  private String tokenServiceStatus;


}
