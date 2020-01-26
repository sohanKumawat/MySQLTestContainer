### Relevant Articles:

Springboot, MySQLContainer,Flyway migration, Spock test cases.

### Execute spock test cases
   mvn clean test-compile  - compile the groovy file
   mvn clean test   - excute all the test cases
   
   MySQLContainer dependecy - 
   
    <dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>mysql</artifactId>
			<version>1.12.5</version>
			<scope>test</scope>
	</dependency>
		
		
Spock dependency and plugin - 

         <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>6.14.3</version>
		</dependency>
	
		<dependency>
			<groupId>org.spockframework</groupId>
			<artifactId>spock-spring</artifactId>
			<version>1.2-groovy-2.4</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.testcontainers</groupId>
			<artifactId>spock</artifactId>
			<version>1.12.5</version>
			<scope>test</scope>
		</dependency>


	<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>

			<plugin>
				<groupId>org.codehaus.gmavenplus</groupId>
				<artifactId>gmavenplus-plugin</artifactId>
				<version>1.6</version>
				<executions>
					<execution>
						<goals>
							<goal>compileTests</goal>
						</goals>
					</execution>
				</executions>
				<configuration>
					<testSources>
						<testSource>
							<directory>${project.basedir}/src/test/java</directory>
							<includes>
								<include>**/*.groovy</include>
							</includes>
						</testSource>
					</testSources>
				</configuration>
			</plugin>

			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>findbugs-maven-plugin</artifactId>
				<configuration>
					<effort>Max</effort>
					<failOnError>false</failOnError>
					<threshold>Low</threshold>
					<xmlOutput>true</xmlOutput>
					<findbugsXmlOutputDirectory>${project.build.directory}/findbugs</findbugsXmlOutputDirectory>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-pmd-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.openclover</groupId>
				<artifactId>clover-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-report-plugin</artifactId>
				<version>2.21.0</version>
				<configuration>
					<testSourceDirectory>src/test/java</testSourceDirectory>
					<includes>
						<include>**/*Spec.groovy</include>
					</includes>
				</configuration>
			</plugin>
		</plugins>   
