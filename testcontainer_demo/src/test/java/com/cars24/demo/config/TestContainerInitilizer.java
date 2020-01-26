package com.cars24.demo.config;

import org.junit.ClassRule;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;

@ContextConfiguration(initializers = {TestContainerInitilizer.Initializer.class})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class TestContainerInitilizer {

  @ClassRule
  public static MySQLContainer<MySQLTestContainer> mySQLContainer =
      MySQLTestContainer.getInstance("mysql/mysql-server", "PRODUCTS").withUsername("root")
          .withPassword("root");

  public static class Initializer
      implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      mySQLContainer.start();
      TestPropertyValues
          .of("spring.datasource.url=" + mySQLContainer.getJdbcUrl(),
              "spring.datasource.username=" + mySQLContainer.getUsername(),
              "spring.datasource.password=" + mySQLContainer.getPassword())
          .applyTo(configurableApplicationContext.getEnvironment());
    }
  }

}
