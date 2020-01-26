package com.cars24.demo.config;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import com.cars24.demo.DemoApplication;
import spock.lang.Specification;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    classes = DemoApplication.class)
@ComponentScan(basePackages = "com.cars24")
@Profile("test")
@ActiveProfiles("test")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
public class WebComponentsConfigSpock extends Specification {

  /**
   * Servlet context.
   *
   * @return the servlet context
   */
  @Bean
  public ServletContext servletContext() {
    return new MockServletContext("", new FileSystemResourceLoader());
  }

  @PostConstruct
  public void prepare() {}

}
