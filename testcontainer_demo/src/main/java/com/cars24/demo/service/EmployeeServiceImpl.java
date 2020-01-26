package com.cars24.demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import com.cars24.demo.bean.EmployeeBean;
import com.cars24.demo.dao.entity.EmployeeEntity;
import com.cars24.demo.dao.service.EmployeeDaoService;
import com.cars24.demo.exception.ValidationException;
import com.cars24.demo.utils.ObjectMapperUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDaoService employeeDaoService;

  @Override
  public EmployeeBean findById(Long id) {
    EmployeeEntity entity = employeeDaoService.findById(id).orElse(null);
    return ObjectMapperUtil.mapper(entity, EmployeeBean.class);
  }

  @Override
  public List<EmployeeBean> findByName(String name) {
    List<EmployeeEntity> entity = employeeDaoService.findByName(name);
    if (CollectionUtils.isEmpty(entity))
      throw new ValidationException("Record not available");
    return ObjectMapperUtil.listMapper(entity, EmployeeBean.class);
  }

  @Override
  public List<EmployeeBean> findByDepartment(String department) {
    List<EmployeeEntity> entity = employeeDaoService.findByDepartment(department);
    if (CollectionUtils.isEmpty(entity))
      throw new ValidationException("Record not available");
    return ObjectMapperUtil.listMapper(entity, EmployeeBean.class);
  }

  @Override
  public EmployeeBean save(EmployeeBean employee) {
    EmployeeEntity entity = ObjectMapperUtil.mapper(employee, EmployeeEntity.class);
    return ObjectMapperUtil.mapper(employeeDaoService.save(entity), EmployeeBean.class);
  }

  @Override
  public List<EmployeeBean> saveAll(List<EmployeeBean> employee) {
    List<EmployeeEntity> entity = ObjectMapperUtil.listMapper(employee, EmployeeEntity.class);
    return ObjectMapperUtil.listMapper(entity, EmployeeBean.class);
  }
}
