package com.example.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.model.Account;
import com.example.repository.AccountRepository;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.example.repository", "com.example.service", "com.example.web" })
@EntityScan(basePackages = "com.example.model")
@EnableJpaRepositories(basePackages = "com.example.repository")
@EnableTransactionManagement
public class TxrSystemConfiguration {

	@Autowired
	private AccountRepository accountRepository;

	@PostConstruct
	public void initDb() {

		Account account1 = new Account("1", 1000.00);
		Account account2 = new Account("2", 1000.00);

		accountRepository.save(account1);
		accountRepository.save(account2);

	}

}
