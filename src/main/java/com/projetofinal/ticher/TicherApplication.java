package com.projetofinal.ticher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TicherApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicherApplication.class, args);
	}

}
