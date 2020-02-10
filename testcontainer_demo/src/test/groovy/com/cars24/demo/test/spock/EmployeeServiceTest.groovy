package com.cars24.demo.test.spock;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Bean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import com.cars24.demo.DemoApplication
import com.cars24.demo.bean.EmployeeBean
import com.cars24.demo.service.EmployeeService
import com.cars24.demo.service.impl.DemoService
import com.cars24.demo.test.config.TestContainerInitilizerTest

import spock.lang.Specification
import spock.mock.DetachedMockFactory

@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizerTest.Initializer.class)
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
		name             | department
		"uttarpradesh1112f" | "786"
		"1234212f"          | "123"
		"12342312f"         | "12341"
	}

	def"findEmployeeService"()
	{

		when:
		EmployeeBean employeeb = employeeService
				.findByName(empName);

		then:
		employeeb.getName()==result

		where:
		empName                  || result
		"uttarpradesh1112f"      || "uttarpradesh1112f"
		"1234212f"               || "1234212f"
	}

	/*def"calculateSum"()
	 {
	 given:
	 def a=10
	 def b=20
	 def demoService = Mock(DemoService.class) {
	 add(a,b) >> 40
	 }
	 when:
	 int result = employeeService.sum(a,b)
	 then:
	 result == 0
	 }*/
}