package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
  @Column(name = "id")
  @SequenceGenerator(name = "token_seq", sequenceName = "Token_SEQ")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
  private Integer id;


  @Column(name = "token_status")
  @Size(max = 50)
  @Enumerated(EnumType.STRING)
  private TokenStatus tokenStatus;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
  private User user;

  @Column(name = "service_type")
  @Size(max = 50)
  @Enumerated(EnumType.STRING)
  private ServiceType serviceType;

  @Column(name = "comments")
  private String comments;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  private Counter counter;

  @Builder.Default
  @Embedded
  private Audit audit = new Audit();

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "token_id")
  private Set<TokenServiceMapping> tokenServiceMappings;

  @Column(name = "is_deleted")
  private Boolean deleted;

}
