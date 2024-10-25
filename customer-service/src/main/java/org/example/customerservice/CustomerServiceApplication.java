package org.example.customerservice;


import org.example.customerservice.dao.entities.Customer;
import org.example.customerservice.dao.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "org.example.customerservice.dao.entities")
@EnableJpaRepositories(basePackages = "org.example.customerservice.dao.repository")
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder().name("Hiba").email("hiba@gmail.com").build());
			customerRepository.save(Customer.builder().name("Ghita").email("ghita@gmail.com").build());
		};
	}

}