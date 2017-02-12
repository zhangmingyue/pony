package com.pony;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pony.dao")
public class PonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PonyApplication.class, args);
	}
}
