package com.cars24.demo.dao.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cars24.demo.dao.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

  List<EmployeeEntity> findByName(String name);

  List<EmployeeEntity> findByDepartment(String department);

}
