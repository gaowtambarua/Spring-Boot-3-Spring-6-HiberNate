package com.gaowtam.aopdemo;

import com.gaowtam.aopdemo.dao.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args)
//	{
//		return runner->{
//			System.out.println("Hello world!");
//		};
//	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO)
	{
		return runner->{

			demoTheBeforAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforAdvice(AccountDAO theAccountDAO) {

		// call the business method
		theAccountDAO.addAccount();

		// do it again!
		System.out.println("\n let's call it again!\n");

		// call the buisness method again
		theAccountDAO.addAccount();
	}

}
