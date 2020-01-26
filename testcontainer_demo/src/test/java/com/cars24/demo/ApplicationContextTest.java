package com.cars24.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import com.cars24.demo.config.TestContainerInitilizer;

@RunWith(SpringRunner.class)

@Profile("test")
@ActiveProfiles("test")
@SpringBootTest(classes = {DemoApplication.class})
@ContextConfiguration(initializers = TestContainerInitilizer.Initializer.class)
public class ApplicationContextTest {

  @Test
  public void whenSpringContextIsBootstrapped_thenNoExceptions() {}
}
