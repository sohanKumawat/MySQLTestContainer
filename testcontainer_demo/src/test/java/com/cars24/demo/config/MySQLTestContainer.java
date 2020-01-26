package com.cars24.demo.config;

import org.testcontainers.containers.MySQLContainer;

public class MySQLTestContainer extends MySQLContainer<MySQLTestContainer> {

  private static String IMAGE_VERSION = "5.7.22";

  private static MySQLTestContainer container;


  public MySQLTestContainer() {
    super(IMAGE_VERSION);
  }

  public MySQLTestContainer(String image) {
    super(image);
  }

  public static MySQLTestContainer getInstance(String image, String dbName) {
    if (container == null) {
      container = new MySQLTestContainer(image);
    }
    container.withDatabaseName(dbName);
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("DB_URL", container.getJdbcUrl());
    System.setProperty("DB_USERNAME", container.getUsername());
    System.setProperty("DB_PASSWORD", container.getPassword());
  }

  @Override
  public void stop() {}
}
