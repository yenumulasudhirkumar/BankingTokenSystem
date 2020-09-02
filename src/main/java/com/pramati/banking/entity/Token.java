package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

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
import javax.validation.constraints.Size;



@Table(name = "token")
@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {

  @Id
  @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(name = "id")
  private String id;


  @Column(name = "token_status")
  @Size(max = 50)
  @Enumerated(EnumType.STRING)
  private TokenStatus tokenStatus;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  private Customer customer;

  @Column(name = "service_type")
  @Size(max = 50)
  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  @Column(name = "comments")
  private String comments;


  @Column(name = "is_multi_service")
  private Boolean multiService;

  @Column(name = "is_deleted")
  private Boolean deleted;

}
