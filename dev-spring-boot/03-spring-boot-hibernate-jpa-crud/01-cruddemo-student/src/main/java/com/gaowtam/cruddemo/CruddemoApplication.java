package com.gaowtam.cruddemo;

import com.gaowtam.cruddemo.dao.StudentDAO;
import com.gaowtam.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args)
//	{
//		return runner->{
//			System.out.println("Hellow World");
//		};
//	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO)
	{
		return runner->{
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentByLastName(studentDAO);

//			udpdateStudent(studentDAO);

//			updateAllLastName(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted=studentDAO.deleteALl();
		System.out.println("Deleted row count: "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId=4;
		System.out.println("Deleting student id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateAllLastName(StudentDAO studentDAO) {
		studentDAO.upateAllLastName();
		queryForStudents(studentDAO);
	}

	private void udpdateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent=studentDAO.findById(studentId);
		System.out.println(myStudent);

		//channge first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setLastName("Barua");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student

		System.out.println("Update Student : "+myStudent);
	}

	private void queryForStudentByLastName(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents=studentDAO.findByLastName("Nirob@gmail.com");

		//display list of students
		for(Student tempStudent :theStudents)
		{
			System.out.println(tempStudent);
		}
	}


	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents=studentDAO.findAll();

		//display list of students
		for(Student tempStudent: theStudents)
		{
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object ... ");
		Student tempStudent=new Student("Nabela","Haque","nabela@gmail.com");

		//save the student
		System.out.println("Saving the student ... ");
		studentDAO.save(tempStudent);

		//dispaly id of the saved student
		int theId=tempStudent.getId();
		System.out.println("Saved student. Genearated id: "+theId);


		//retrive student based on the id:primary key
		System.out.println("Reterieving student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);

		//display student;
		System.out.println("Found the student: "+myStudent);
		System.out.println("Found the student: "+myStudent.getFirstName());
	}

	private void createMultipleStudent(StudentDAO studentDAO) {

		Student tempStuden1=new Student("Gaowtam","Barua","gaowtam@gmail.com");
		Student tempStudent2=new Student("Shipon","Barua","shipon@gmail.com");
		Student tempStuden3=new Student("Nirob","Ahmed","Nirob@gmail.com");

		studentDAO.save(tempStuden1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStuden3);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student onject
		System.out.println("Create new student object ... ");
		Student tempStudent=new Student("Paul","Doe","paoul@gmail.com");

		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saced student. Generated id: "+tempStudent.getId());
	}


}
