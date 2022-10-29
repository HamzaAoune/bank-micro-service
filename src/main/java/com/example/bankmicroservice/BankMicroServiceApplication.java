package com.example.bankmicroservice;

import com.example.bankmicroservice.entities.BankAccount;
import com.example.bankmicroservice.enums.AccountType;
import com.example.bankmicroservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BankMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankMicroServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(BankAccountRepository bankAccountRepository){
		return args -> {
			for (int i = 0 ; i < 10 ; i++)
			{
				BankAccount bankAccount = BankAccount.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT: AccountType.SAVING_ACCOUNT)
						.balance(10000+Math.random()*89000)
						.createdAt(new Date())
						.currency("MAD")
						.build();

				bankAccountRepository.save(bankAccount);
			}
		};
	}
}
