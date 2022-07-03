package com.xyzbank.retail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * The Spring boot program implements an application that simply displays
 * Debit/Credit to the standard output.
 * 
 * @author Sudhahar
 * @version 1.0
 * @since 2022-07-01
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "XYZ Retail Bank API", version = "1.0", description = "Credit Debit Information"))
public class XyzRetailBankDemoApp {

	public static void main(String[] args) {
		SpringApplication.run(XyzRetailBankDemoApp.class, args);
	}

}
