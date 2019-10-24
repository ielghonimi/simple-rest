package com.honor.simulator;

import com.honor.simulator.order.api.dto.CustomerDto;
import com.honor.simulator.order.persistence.DataStore;
import com.honor.simulator.order.persistence.entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimulatorApplication {

	private final static Logger log = LoggerFactory.getLogger(SimulatorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SimulatorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(DataStore repository) {
		return (args) -> {
			// save a couple of customers
			repository.createCustomer(new CustomerDto("Jack"));
			repository.createCustomer(new CustomerDto("Chloe"));
			repository.createCustomer(new CustomerDto("Kim"));
			repository.createCustomer(new CustomerDto("David"));
			repository.createCustomer(new CustomerDto("Michelle"));

		};
	}


}
