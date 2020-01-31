package com.cars24.demo.test.spock;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import com.cars24.demo.DemoApplication
import com.cars24.demo.service.EmployeeService
import com.cars24.demo.service.impl.DemoService
import com.cars24.demo.test.config.TestContainerInitilizer
import spock.lang.Specification


@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
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