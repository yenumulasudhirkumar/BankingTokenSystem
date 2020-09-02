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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

  @Id
  @Column(name = "id")
  @SequenceGenerator(name = "user_seq", sequenceName = "USER_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
  private Integer id;

  @Column(name = "user_name",unique = true)
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "gender")
  private String gender;

  @Column(name = "phone",unique = true)
  private String phone;

  @Column(name = "email",unique = true)
  private String email;

  @Column(name = "address")
  private String address;

  @Column(name = "dob")
  private String dob;

  @Column(name = "is_deleted")
  private Boolean deleted;

  @Column(name = "user_role")
  @Enumerated(EnumType.STRING)
  private UserRole userRole;

  @Column(name = "branch_name")
  private String branchName;


  @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private Customer customer;

  @OneToOne(mappedBy = "user")
  private Employee employee;


}
