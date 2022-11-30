package com.soulmatebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan
@SpringBootApplication
public class SoulmateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoulmateServiceApplication.class, args);
	}

}
