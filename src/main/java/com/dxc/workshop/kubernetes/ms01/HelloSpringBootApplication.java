package com.dxc.workshop.kubernetes.ms01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
// Teste do build e push
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
		log.info("The application is using {} mb", (Runtime.getRuntime().totalMemory() / 1024 / 1024));
	}

}
