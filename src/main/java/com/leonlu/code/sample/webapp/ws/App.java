package com.leonlu.code.sample.webapp.ws;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
