package com.sandog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sandog.jinyun")
public class JinyunAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinyunAppApplication.class, args);
	}

}
