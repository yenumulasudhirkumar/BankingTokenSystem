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
import javax.validation.constraints.Size;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "counter")
public class Counter implements Serializable {


  @Id
  @Column(name = "id")
  @GeneratedValue(generator = "uuid2")
  private Integer id;


  @Column(name = "counter_service_type")
  @Size(max = 100)
  private String counterServiceType;

  @Column(name = "queue_size")
  private int queueSize;


}
