package com.cars24.demo.dao.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cars24.demo.dao.entity.EmployeeEntity;
import com.cars24.demo.dao.repository.EmployeeRepository;
import com.cars24.demo.dao.service.EmployeeDaoService;

@Service
public class EmployeeDaoServiceImpl implements EmployeeDaoService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public Optional<EmployeeEntity> findById(Long id) {
    return employeeRepository.findById(id);
  }

  @Override
  public EmployeeEntity findByName(String name) {
    return employeeRepository.findByName(name);
  }

  @Override
  public List<EmployeeEntity> findByDepartment(String department) {
    return employeeRepository.findByDepartment(department);
  }

  @Override
  public EmployeeEntity save(EmployeeEntity employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public List<EmployeeEntity> saveAll(List<EmployeeEntity> employee) {
    return employeeRepository.saveAll(employee);
  }

}
