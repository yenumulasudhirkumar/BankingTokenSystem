package com.pramati.banking.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "service")
public class Service {

  @Id
  @Column(name = "id")
  private Integer id;

  @Column(name = "service_name")
  private String serviceName;

  @Column(name = "is_multicounter_service")
  private boolean multiCounterService;

  @Column(name = "mapping_status_id")
  private Integer mappingStatusId;

  @Column(name = "is_deleted")
  private boolean deleted;
}
