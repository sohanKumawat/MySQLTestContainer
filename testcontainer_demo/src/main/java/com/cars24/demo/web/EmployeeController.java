package com.cars24.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cars24.demo.bean.EmployeeBean;
import com.cars24.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {


  @Autowired
  private EmployeeService employeeService;


  @GetMapping("/{id}")
  public EmployeeBean findById(@PathVariable Long id) {
    return employeeService.findById(id);
  }

  @GetMapping("/name/{name}")
  public EmployeeBean findByName(@PathVariable String name) {
    return employeeService.findByName(name);
  }

  @GetMapping("/department/{department}")
  public List<EmployeeBean> findByDepartment(@PathVariable String department) {
    return employeeService.findByDepartment(department);
  }

  @PostMapping("/")
  public EmployeeBean save(@RequestBody EmployeeBean employee) {
    return employeeService.save(employee);
  }

  @PostMapping("/all")
  public List<EmployeeBean> saveAll(@RequestBody List<EmployeeBean> employee) {
    return employeeService.saveAll(employee);
  }


}
