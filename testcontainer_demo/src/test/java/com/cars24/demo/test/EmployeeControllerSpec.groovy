package com.cars24.demo.test;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.web.servlet.MockMvc
import com.cars24.demo.bean.EmployeeBean
import com.cars24.demo.config.WebComponentsConfigSpock
import com.cars24.demo.dateprovider.DataProvider
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import spock.lang.Shared

class EmployeeControllerSpec extends WebComponentsConfigSpock {

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


  def"SaveEmployee"()
  {
    given:
    EmployeeBean request = DataProvider.getEmployee();
    request.setName(name)
    request.setDepartment(department)


    mvc.perform(post("/employee")
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(request)))
        .andExpect(status().is(result))
        .andReturn()
        .response != null

    expect: "Status is 200"

    where:
    name            | department      || result
    "uttarpradesh11"| "786"           || 200
    "12342"         | "123"           || 200
    "123451"        | "1234"          || 200
  }

  def"findEmployee"()
  {
    given:
    def eName=empName
    mvc.perform(get("/employee/name/"+eName)
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(request)))
        .andExpect(status().is(result))
        .andReturn()
        .response != null

    where:
    empName               || result
    "uttarpradesh11"      || 200
    "12342"               || 200
    "sdfgd"               || 400

  }

}
