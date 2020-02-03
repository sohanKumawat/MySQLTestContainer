package com.cars24.demo.test.config;

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.testcontainers.containers.MySQLContainer
import spock.lang.Specification

public class TestContainerInitilizerTest extends Specification {

  public static MySQLContainer mySQLContainer =null;
  public static class Initializer
  implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
      if(mySQLContainer==null)
        mySQLContainer = new MySQLContainer("mysql/mysql-server");
      mySQLContainer.withDatabaseName("HRMS")
      mySQLContainer.start();
      System.setProperty("DB_URL", mySQLContainer.getJdbcUrl());
      System.setProperty("DB_USERNAME", mySQLContainer.getUsername());
      System.setProperty("DB_PASSWORD", mySQLContainer.getPassword());
    }
  }
}
