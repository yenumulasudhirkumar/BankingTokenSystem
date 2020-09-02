package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "counter_service_mapping")
public class CounterServiceMapping implements Serializable {

  @Id
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  private Service service;

  @ManyToOne
  private Counter counter;

  @Column(name = "is_deleted")
  private boolean deleted;
}
