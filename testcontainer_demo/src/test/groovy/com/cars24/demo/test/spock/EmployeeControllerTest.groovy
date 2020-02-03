package com.cars24.demo.test.spock;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import com.cars24.demo.DemoApplication
import com.cars24.demo.bean.EmployeeBean
import com.cars24.demo.test.config.TestContainerInitilizerTest
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import spock.lang.Shared
import spock.lang.Specification

@AutoConfigureMockMvc
@SpringBootTest(classes = DemoApplication.class)
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@ContextConfiguration(initializers = TestContainerInitilizerTest.Initializer.class)
public class EmployeeControllerTest extends Specification {

  @Autowired
  private MockMvc mvc

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

  //@Unroll
  def"SaveEmployeeController"()
  {
    given:
    EmployeeBean request = EmployeeBean.builder().department("Tech").name("Sohan").salary("1L").build();
    request.setName(name)
    request.setDepartment(department)

    mvc.perform(post("/employee/")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(request)))
        .andExpect(status().is(result))
        .andReturn()
        .response != null

    //    mvc.perform(get("/employee/name/"+name)
    //        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
    //        .andExpect(status().is(result))
    //        .andReturn()
    //        .response != null

    where:
    name            | department      || result
    "uttarpradesh11"| "786"           || 200
    "12342"         | "123"           || 200
    "123451"        | "1234"          || 200
  }

  def"findEmployeeController"()
  {
    mvc.perform(get("/employee/name/"+empName)
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON))
        .andExpect(status().is(result))
        .andReturn()
        .response != null
    where:
    empName               || result
    "uttarpradesh11"      || 200
    "12342"               || 200
    "123451"              || 200
  }

}
