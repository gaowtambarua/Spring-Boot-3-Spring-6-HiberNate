package com.gaowtam.cruddemo;

import com.gaowtam.cruddemo.dao.AppDAO;
import com.gaowtam.cruddemo.entity.Instructor;
import com.gaowtam.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args)
//	{
//		return  runner->{
//			System.out.println("Hellow World");
//		};
//	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO)
	{
		return  runner->{
//			createInstructory(appDAO);
//
//			findInstructory(appDAO);
//
//			deleteInstructor(appDAO);

			findInstructorDetail(appDAO);
		};
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId=2;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: "+tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instrcutor: "+tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(3);
		System.out.println("Done!");
	}

	private void findInstructory(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associate instructorDetail only: "+tempInstructor.getInstructorDetail());
	}

	private void createInstructory(AppDAO appDAO) {

	/*	// create ths instructor
		Instructor tempInstructor=new Instructor("Nabela","Haque","Nabela@gmail.com");

		// create th instructory detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.gaowtam.com",
				"Gaowtam 2 CODE !!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
	 */

		// create ths instructor
		Instructor tempInstructor=new Instructor("Madhu","Patel","Madhu@gmail.com");

		// create th instructory detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.gaowtam.com",
				"Guiter !!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructory
		//
 		// NOTE: this will save the details object
 		// because of CascadeTYPE.ALL

		System.out.println("Saving instructory: "+tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");
	}
}
