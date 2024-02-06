package com.secureProgramming.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
		"com.secureProgramming.assignment.Controller",
		"com.secureProgramming.assignment.Model",
		"com.secureProgramming.assignment.Service",
		"com.secureProgramming.assignment.Repository",
		"com.secureProgramming.assignment.InputValidator"
})
public class AssignmentApplication {

	public static void main(String[] args) {

		SpringApplication.run(AssignmentApplication.class, args);
	}

}
