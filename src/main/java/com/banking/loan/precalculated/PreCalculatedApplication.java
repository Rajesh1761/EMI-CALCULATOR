package com.banking.loan.precalculated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.banking.loan.config.LoanAppConfig;

@SpringBootApplication
public class PreCalculatedApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanAppConfig.class, args);
	}

}
