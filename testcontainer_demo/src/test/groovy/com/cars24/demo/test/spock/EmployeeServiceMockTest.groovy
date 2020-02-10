package com.cars24.demo.test.spock;

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import com.cars24.demo.DemoApplication
import com.cars24.demo.service.EmployeeService
import com.cars24.demo.service.impl.DemoService
import com.cars24.demo.test.config.TestContainerInitilizerTest

import spock.lang.Specification
import spock.lang.Stepwise



@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizerTest.Initializer.class)
@Stepwise
public class EmployeeServiceMockTest extends Specification {


	@Autowired
	private EmployeeService employeeService

	@SpringBean
	private DemoService demoService = Stub()

	def cleanupSpec() {
		println("Cleanup after all tests!")
	}


	def "employeServiceMock"() {
		setup:
		def a=10
		def b=20

		demoService.add(a,b) >> 50

		when:
		int result = employeeService.sum(a,b)

		then:
		result == 80
	}

	def"calculateSum"() {
		given:
		def a=10
		def b=20
		demoService.add(a,b) >> 40
		when:
		int result = employeeService.sum(a,b)
		then:
		result == 70
	}
	/*@TestConfiguration
	 static class MockConfig {
	 def detachedMockFactory = new DetachedMockFactory()
	 @Bean("demoServiceMock")
	 DemoService demoService() {
	 return detachedMockFactory.Stub(DemoService)
	 }
	 }*/
}