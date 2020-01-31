package com.cars24.demo.test.spock;

import com.cars24.demo.service.EmployeeService
import com.cars24.demo.service.impl.DemoService
import spock.lang.Specification


class EmployeeServiceMockSpec extends Specification {

  def cleanupSpec() {
    println("Cleanup after all tests!")
  }


  def "employeServiceMock"() {
    setup:
    def a=10
    def b=20

    def demoService = Mock(DemoService.class) {
      add(a,b) >> 40
    }
    def employeeService = Mock(EmployeeService.class) {
      sum(a,b) >> 60
    }


    when:
    int result = employeeService.sum(a,b)

    then:
    result == 60
  }
}