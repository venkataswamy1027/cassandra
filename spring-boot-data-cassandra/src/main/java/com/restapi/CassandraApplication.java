package com.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.datastax.driver.core.utils.UUIDs;
import com.restapi.model.Customer;
import com.restapi.repository.CustomerRepository;

@SpringBootApplication
public class CassandraApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.repository.deleteAll();

		// save a couple of customers
		this.repository.save(new Customer(UUIDs.timeBased(), "siva", "reddy"));
		this.repository.save(new Customer(UUIDs.timeBased(), "ramu", "naik"));

		// fetch all customers
		System.out.println();
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : this.repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();
	}

}
