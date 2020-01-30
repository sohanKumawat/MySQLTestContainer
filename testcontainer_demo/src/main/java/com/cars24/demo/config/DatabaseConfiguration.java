package com.cars24.demo.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.cars24.demo.dao.*",
    entityManagerFactoryRef = "productEntityManager",
    transactionManagerRef = "productTransactionManager")
@EnableTransactionManagement
public class DatabaseConfiguration {
  @Autowired
  private Environment env;

  @Bean("productEntityManager")
  @Primary
  public LocalContainerEntityManagerFactoryBean productEntityManager() {
    System.out.println("hbm2ddl " + env.getProperty("hibernate.hbm2ddl.auto"));
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(productDataSource());
    em.setPackagesToScan("com.cars24.demo.dao.*");
    em.setPersistenceUnitName("productPUnit");

    final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setShowSql(Boolean.valueOf(env.getProperty("hibernate.show_sql")));
    em.setJpaVendorAdapter(vendorAdapter);
    final HashMap<String, Object> properties = new HashMap<String, Object>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl"));
    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    em.setJpaPropertyMap(properties);

    return em;
  }

  @Bean("productDataSource")
  @Primary
  public DataSource productDataSource() {

    System.out.println("product.jdbc.url " + env.getProperty("product.jdbc.url"));

    System.out.println("jdbc.user " + env.getProperty("jdbc.user"));

    System.out.println("jdbc.pass " + env.getProperty("jdbc.pass"));
    System.out.println("jdbc.pass " + env.getProperty("jdbc.pass"));
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
    dataSource.setUrl(env.getProperty("product.jdbc.url"));
    dataSource.setUsername(env.getProperty("jdbc.user"));
    dataSource.setPassword(env.getProperty("jdbc.pass"));

    return dataSource;
  }

  @Bean("productTransactionManager")
  @Primary
  public PlatformTransactionManager productTransactionManager() {
    final JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(productEntityManager().getObject());
    return transactionManager;
  }

}
