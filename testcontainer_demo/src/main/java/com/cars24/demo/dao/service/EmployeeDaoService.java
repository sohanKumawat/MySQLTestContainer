package com.cars24.demo.dao.service;

import java.util.List;
import java.util.Optional;
import com.cars24.demo.dao.entity.EmployeeEntity;

public interface EmployeeDaoService {


  EmployeeEntity save(EmployeeEntity employee);

  List<EmployeeEntity> saveAll(List<EmployeeEntity> employee);

  Optional<EmployeeEntity> findById(Long id);

  List<EmployeeEntity> findByName(String name);

  List<EmployeeEntity> findByDepartment(String department);

}
