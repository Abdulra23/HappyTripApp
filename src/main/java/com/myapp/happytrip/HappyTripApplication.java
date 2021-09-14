package com.myapp.happytrip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class HappyTripApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyTripApplication.class, args);
	}

}
