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
import com.cars24.demo.test.config.TestContainerInitilizerTest
import spock.lang.Specification
import spock.lang.Stepwise

@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
//@ComponentScan(basePackages = "com.cars24")
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizerTest.Initializer.class)
@Stepwise
public class EmployeeServiceTest extends Specification {


  @Autowired
  private EmployeeService employeeService

  def cleanupSpec() {
    println("Cleanup after all tests!")
  }

  // @Unroll
  def "SaveEmployeeService"()
  {

    //setup block
    //when and then blocks
    //expect block
    //cleanup block
    //where block
    given:
    EmployeeBean request = EmployeeBean.builder().department("Tech").name("Sohan").salary("1L").build();
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
    "uttarpradesh1112" | "786"           || "uttarpradesh11"
    "1234212"          | "123"           || "12342"
    "12342312"         | "12341"         || "123423"
  }

  def"findEmployeeService"()
  {

    when:
    EmployeeBean employeeb = employeeService
        .findByName(empName);

    then:
    employeeb.getName()==result

    where:
    empName               || result
    "uttarpradesh1112"      || "uttarpradesh1112"
    "1234212"               || "1234212"
  }
}