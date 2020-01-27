package com.cars24.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeBean {

  private Long id;

  private String name;

  private String salary;

  private String department;

  private String userBy;

}
