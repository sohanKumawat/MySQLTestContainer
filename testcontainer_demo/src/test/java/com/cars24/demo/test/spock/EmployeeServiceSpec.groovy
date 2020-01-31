package com.cars24.demo.test.spock;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import com.cars24.demo.DemoApplication
import com.cars24.demo.bean.EmployeeBean
import com.cars24.demo.service.EmployeeService
import com.cars24.demo.test.config.TestContainerInitilizer
import com.cars24.demo.test.dateprovider.DataProvider
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Stepwise

@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
//@ComponentScan(basePackages = "com.cars24")
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
@Stepwise
class EmployeeServiceSpec extends Specification {


  @Autowired
  private EmployeeService employeeService

  // Must be @Shared or static!
  def @Shared ObjectMapper mapper

  //Run before all the tests:
  def setupSpec() {
    mapper =
        new ObjectMapper()
    mapper.registerModule(new JavaTimeModule())
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
  }

  def cleanupSpec() {
    println("Cleanup after all tests!")
  }


  def "SaveEmployee"()
  {

    //setup block
    //when and then blocks
    //expect block
    //cleanup block
    //where block
    given:
    EmployeeBean request = DataProvider.getEmployee();
    request.setName(name)
    request.setDepartment(department)

    when : "Pass the employee bean request and save into the db"
    EmployeeBean employeeBean = employeeService
        .save(request);

    and: "Compare the save entity name value with passed name value"
    EmployeeBean employee1 = employeeService
        .findByName(name);

    then: 'Should return null when a value is not found with the given key'
    employeeBean.getName()== employee1.getName()

    //cleanup:

    where:
    name             | department      || result
    "uttarpradesh11" | "786"           || "uttarpradesh11"
    "12342"          | "123"           || "12342"
    "123423"         | "12341"         || "123423"
  }

  def"findEmployee"()
  {

    when:
    EmployeeBean employeeb = employeeService
        .findByName(empName);

    then:
    employeeb.getName()==result

    where:
    empName               || result
    "uttarpradesh11"      || "uttarpradesh11"
    "12342"               || "12342"
  }
}