package com.crudproject.crudproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.thymeleaf.context.Context;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EntityScan
public class CrudprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudprojectApplication.class, args);
	}


}
