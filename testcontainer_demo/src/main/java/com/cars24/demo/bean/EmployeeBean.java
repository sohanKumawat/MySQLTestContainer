package com.cars24.demo.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeBean {

  private Long id;

  private String name;

  private String salary;

  private String department;

  private String userBy;

}
