// Package declaration
package com.glg3b7.trackticket;

// Import statements for Spring Boot classes
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Annotation to denote this class as the main Spring Boot application class.
// @SpringBootApplication is a convenience annotation that adds:
// - @Configuration: Tags the class as a source of bean definitions.
// - @EnableAutoConfiguration: Tells Spring Boot to start adding beans based on classpath settings,
//   other beans, and various property settings.
// - @ComponentScan: Tells Spring to look for other components, configurations, and services
//   in the com.glg3b7.trackticket package, allowing it to find controllers, services, etc.
@SpringBootApplication
public class TrackticketApplication {

	// The main method - entry point for the Spring Boot application.
	public static void main(String[] args) {
		// SpringApplication.run() method launches the application.
		// It sets up the default configuration, starts the Spring application context,
		// and performs the classpath scan for beans and annotations.
		SpringApplication.run(TrackticketApplication.class, args);
	}

}
