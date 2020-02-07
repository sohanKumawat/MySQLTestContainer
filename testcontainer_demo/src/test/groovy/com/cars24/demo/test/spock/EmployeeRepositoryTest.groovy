package com.cars24.demo.test.spock;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import com.cars24.demo.config.DatabaseConfiguration
import com.cars24.demo.dao.entity.EmployeeEntity
import com.cars24.demo.dao.repository.EmployeeRepository
import com.cars24.demo.test.config.TestContainerInitilizerTest
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Shared
import spock.lang.Specification




@SpringBootTest(classes = DatabaseConfiguration.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizerTest.Initializer.class)
public class EmployeeRepositoryTest extends Specification {


  // Must be @Shared or static!
  def @Shared ObjectMapper mapper

  @Autowired
  private EmployeeRepository employeeRepository;


  def setupSpec() {
    println("setupSpec before all tests!")
  }
  def cleanupSpec() {
    println("Cleanup after all tests!")
  }

  //@Unroll
  def"SaveAndFindEmployeeRepo"()
  {

    given :
    EmployeeEntity employee1 = new EmployeeEntity(name,salary,department);

    when:
    EmployeeEntity savedEntity= employeeRepository.save(employee1);

    then:
    EmployeeEntity findEntity= employeeRepository.findByName(name);

    expect :
    findEntity!=null
    findEntity.getName()==name

    where:
    name               |  salary   | department      || result
    "uttarpradesh11sd" | "10000"   | "786"           || 200
    "12342sd"          | "20000"   | "123"           || 200
    "1234512d"         | "50000"   | "1234"          || 200

  }
}