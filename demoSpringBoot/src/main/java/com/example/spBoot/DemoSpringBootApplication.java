package com.example.spBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(scanBasePackages = {"com.example.spBoot", "com.example.spBoot1"})
//it is used when Entity is outside the base package

@SpringBootApplication

public class DemoSpringBootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(DemoSpringBootApplication.class, args);
//		Car c = (Car)run.getBean(Car.class);
	}
}