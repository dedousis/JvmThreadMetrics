package com.upstreamsystems.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScan("com.upstreamsystems")
@EnableAsync
public class JvmthreadsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JvmthreadsApplication.class, args);
	}

}
