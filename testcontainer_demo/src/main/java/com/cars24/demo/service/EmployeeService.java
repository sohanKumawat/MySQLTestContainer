package com.cars24.demo.service;

import java.util.List;
import com.cars24.demo.bean.EmployeeBean;

public interface EmployeeService {


  EmployeeBean save(EmployeeBean employee);

  List<EmployeeBean> saveAll(List<EmployeeBean> employee);

  EmployeeBean findById(Long id);

  List<EmployeeBean> findByName(String name);

  List<EmployeeBean> findByDepartment(String department);

}
