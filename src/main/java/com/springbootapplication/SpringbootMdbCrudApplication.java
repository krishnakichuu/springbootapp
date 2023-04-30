package com.springbootapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SpringbootMdbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMdbCrudApplication.class, args);
	}

}
