// package com.cars24.demo.test.testng;
//
// import java.util.List;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
// import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.ActiveProfiles;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.context.junit4.SpringRunner;
// import com.cars24.demo.DemoApplication;
// import com.cars24.demo.bean.EmployeeBean;
// import com.cars24.demo.service.EmployeeService;
// import com.cars24.demo.test.config.TestContainerInitilizer;
//
//
// @RunWith(SpringRunner.class)
// @ActiveProfiles("test")
// @SpringBootTest(classes = DemoApplication.class)
// @EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
// @ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
// public class EmployeeServiceTest {
//
// @Autowired
// private EmployeeService employeeService;
//
//
// @Test
// public void getEmployeeTest() throws Exception {
// EmployeeBean employeeBean = employeeService.findById(1L);
// System.out.println(employeeBean);
// }
//
// @Test
// public void testEmployee() throws Exception {
// EmployeeBean employeeBean = employeeService
// .save(EmployeeBean.builder().name("sohan").department("tech").salary("100k").build());
// List<EmployeeBean> employeeBeans = employeeService.findByName("sohan");
// System.out.println(employeeBeans.size());
// }
//
// }
