package com.ssau.learn;

import com.ssau.learn.entity.Bank;
import com.ssau.learn.dao.BankRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Bean
	CommandLineRunner runner(BankRepository repository){
		return args -> {
			Bank bankSamara = new Bank("0436016070","ПОВОЛЖСКИЙ БАНК ПАО СБЕРБАНК", "Самара");
			if (repository.findByID("043601607") == null){
				repository.save(bankSamara);
			}
			//repository.insert(bankSamara);
			System.out.println(repository.existsById("043601607"));

		};

	}*/
}
