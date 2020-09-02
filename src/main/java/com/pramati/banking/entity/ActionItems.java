package com.pramati.banking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Table;


@Table(name = "action_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionItems implements Serializable {

  private Integer id;

  private String actionName;

  private Token token;

  private Boolean deleted;


}
