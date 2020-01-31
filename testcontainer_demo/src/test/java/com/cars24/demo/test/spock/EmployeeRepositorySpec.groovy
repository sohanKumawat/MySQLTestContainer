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
import com.cars24.demo.test.config.TestContainerInitilizer
import com.fasterxml.jackson.databind.ObjectMapper
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll




@SpringBootTest(classes = DatabaseConfiguration.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
class EmployeeRepositorySpec extends Specification {


  // Must be @Shared or static!
  def @Shared ObjectMapper mapper

  // private static final EmployeeEntity EMPLOYEE1 = new EmployeeEntity("John","10000","tech");
  // private static final EmployeeEntity EMPLOYEE2 = new EmployeeEntity("Alice","15000","Operation");

  @Autowired
  private EmployeeRepository employeeRepository;


  def cleanupSpec() {
    println("Cleanup after all tests!")
  }

  @Unroll
  def"SaveAndFindEmployee"()
  {

    given :
    EmployeeEntity EMPLOYEE1 = new EmployeeEntity(name,salary,department);

    when:
    EmployeeEntity savedEntity= employeeRepository.save(EMPLOYEE1);

    then:
    EmployeeEntity findEntity= employeeRepository.findByName(name);

    expect :
    findEntity!=null
    findEntity.getName()==name

    where:
    name             |  salary   | department      || result
    "uttarpradesh11" | "10000"   | "786"           || 200
    "12342"          | "20000"   | "123"           || 200
    "123451"         | "50000"   | "1234"          || 200



  }
}