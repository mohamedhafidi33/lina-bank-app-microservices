package org.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.customer.service.entities.Customer;
import org.customer.service.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {

			List<Customer> customerList = List.of(
					Customer.builder().firstName("Hassan").lastName("Elhoumi").email("hassan@gmail.com").build(),
					Customer.builder().firstName("Mohamed").lastName("Elhannaoui").email("hassan@gmail.com").build()

			);
			customerRepository.saveAll(customerList);
		};
	}
}
