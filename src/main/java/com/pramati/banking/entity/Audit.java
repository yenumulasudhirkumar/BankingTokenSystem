package com.pramati.banking.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


@Embeddable
@Getter
@Setter
public class Audit {

  @Column(name = "created_date")
  private LocalDateTime createdOn;


  @Column(name = "last_updated_date")
  private LocalDateTime updatedOn;


  @PrePersist
  public void prePersist() {
    createdOn = LocalDateTime.now();
  }

  @PreUpdate
  public void preUpdate() {
    updatedOn = LocalDateTime.now();
  }
}
