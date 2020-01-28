package com.cars24.demo.test.spock;

import com.cars24.demo.bean.EmployeeBean
import com.cars24.demo.service.EmployeeService
import spock.lang.Specification

public class EmployeeServiceReaderSpec extends Specification {

  public void "EMploye service mock demo"() {
    given: "Employee name values"
    EmployeeBean employee = new EmployeeBean()
    employee.setName("sohan")
    employee.setDepartment("Technology")

    and: "Mocking employe service"
    EmployeeService employeeService = Stub(EmployeeService.class)
    employeeService.findById(1L) >> employee

    when: "Find employe by id"
    EmployeeBean employee1 = employeeService.findById(1L)

    then: "Compare employee service name"
    employee1.getName() == "sohan"
  }
}
