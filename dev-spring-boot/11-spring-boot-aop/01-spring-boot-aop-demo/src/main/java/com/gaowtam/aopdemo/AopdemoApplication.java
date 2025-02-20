package com.gaowtam.aopdemo;

import com.gaowtam.aopdemo.dao.AccountDAO;
import com.gaowtam.aopdemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO thMembershipDAO)
	{
		return runner->{

			demoTheBeforAdvice(theAccountDAO,thMembershipDAO);
		};
	}

	private void demoTheBeforAdvice(AccountDAO theAccountDAO,MembershipDAO thMembershipDAO) {

		// call the business method
//		theAccountDAO.addAccount();

		Account myAccount=new Account();
		theAccountDAO.addAccount(myAccount,true);

		// call the membership business method
		thMembershipDAO.addSillyMember();
	}

}
