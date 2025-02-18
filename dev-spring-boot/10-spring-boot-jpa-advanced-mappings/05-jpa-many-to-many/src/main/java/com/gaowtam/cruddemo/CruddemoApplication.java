package com.gaowtam.cruddemo;

import com.gaowtam.cruddemo.dao.AppDAO;
import com.gaowtam.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

//			createCourseAndStudents(appDAO);

//			findCourseAndStudents(appDAO);

//			findStudentAndCourses(appDAO);

//			addMoreCoursesForStudent(appDAO);

//			deleteCourse(appDAO);

			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int theId=2;
		System.out.println("Deleting student id: "+theId);

		appDAO.deleteStudentById(theId);
		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int theId=2;
		Student tempStudent=appDAO.findStudentAndCourseByStudentId(theId);

		// create more courses
		Course tempCourse1=new Course("Rubik's Cube -How to Speed Cube");
		Course tempCourse2=new Course("Atari 2600- Game Development");

		// add courses to student
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);

		System.out.println("Updating student: "+tempStudent);
		System.out.println("associated courses: "+tempStudent.getCourses());

		appDAO.update(tempStudent);
		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=2;

		Student tempStudent=appDAO.findStudentAndCourseByStudentId(theId);

		System.out.println("Loaded student: "+tempStudent);
		System.out.println("Courses: "+tempStudent.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int theId=10;

		Course thempCourse=appDAO.findCourseAndStudentsByCourseId(theId);

		System.out.println("Loaded course: "+thempCourse);
		System.out.println("Students: "+thempCourse.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course tempCourse=new Course("Pacman - How To Score One Million Points");

		// create the students
		Student tempStudent1=new Student("John","Doe","john@gmail.com");
		Student tempStudent2=new Student("Mary","Public","mary@gmail.com");

		// add students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);

		// save the course and associated students
		System.out.println("Saving the course: "+tempCourse);
		System.out.println("associated students: "+tempCourse.getStudents());
		appDAO.save(tempCourse);
		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=15;

		System.out.println("Delete Course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		int theId=10;
		Course temCourse=appDAO.findCourseAndReviewsByCourseId(theId);
		// print the course
		System.out.println(temCourse);

		// print the reviews
		System.out.println(temCourse.getReviews());
		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		// create a course
		Course tempCourse=new Course("Pacman - How To Score One Million Pointsa");

		// add some reviews
		tempCourse.addReview(new Review("Great course .... loved it! "));
		tempCourse.addReview(new Review("Cool course,job well done."));
		tempCourse.addReview(new Review("What a dumb course,you are an idiot!"));

		// save the course
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Deleting couurse id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;

		//find the course
		System.out.println("Finding course id: "+theId);
		Course tempCourse=appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating course id: "+theId);
		tempCourse.setTitle("Enjoy the Simple Things");
		appDAO.update(tempCourse);
		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;

		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);

		//update the instructor
		System.out.println("Update instructor id: "+theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCorsesJoinFetch(AppDAO appDAO) {
		int theId=1;

		//find the instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associate courses: "+tempInstructor.getCourses());
		System.out.println("the instructor detail: "+tempInstructor.getInstructorDetail());
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;

		//find instructor
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);

		// FetchType.LAZY Loded
		// Find courses for instructor
		System.out.println("Finding courses for instructor id: "+theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCorses(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor=appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create ths instructor
		Instructor tempInstructor=new Instructor("Susan","Public","Susa@gmail.com");

		// create th instructory detail
		InstructorDetail tempInstructorDetail=new InstructorDetail("youtube.com",
				"Video Games !!!");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some corses
		Course tempCourse1=new Course("Air Guiter - The Ultimate Guide");
		Course tempCourse2=new Course("The PinBall Masterclass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		//save the instructor
		//
 		//Note: this will Also save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving instructor: "+tempInstructor);
		System.out.println("The courses: "+tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

	private void deleteInstructorDetail(AppDAO dao) {
		int theId=6;
		System.out.println("Deleting instructor detail id: "+theId);
		dao.deleteInstructorDetailById(theId);
		System.out.println("Done!");
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
		int theId=1;
		System.out.println("Deleting instructor id: "+theId);
		appDAO.deleteInstructorById(theId);
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
