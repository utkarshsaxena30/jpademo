package com.btimfl.jpa.jpademo;

import com.btimfl.jpa.jpademo.dao.InstructorDAO;
import com.btimfl.jpa.jpademo.dao.InstructorDetailDAO;
import com.btimfl.jpa.jpademo.entity.Instructor;
import com.btimfl.jpa.jpademo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO, InstructorDetailDAO instructorDetailDAO) {
		return runner -> {
			// createInstructor(instructorDAO);
			// findInstructorById(instructorDAO);
			// deleteInstructorById(instructorDAO);
			findInstructorDetailById(instructorDetailDAO);
		};
	}

	private void findInstructorDetailById(InstructorDetailDAO instructorDetailDAO) {
		InstructorDetail instructorDetail = instructorDetailDAO.findInstructorDetailById(3);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructorById(InstructorDAO instructorDAO) {
		instructorDAO.deleteInstructorById(1);
	}

	private void findInstructorById(InstructorDAO instructorDAO) {
		Instructor instructor = instructorDAO.findInstructorById(1);
		System.out.println(instructor);
	}

	private void createInstructor(InstructorDAO instructorDAO) {
		Instructor instructor = new Instructor("John", "Doe", "john@doe.com");
		instructor.setInstructorDetail(new InstructorDetail("john_doe_youtube", "kayaking"));

		instructorDAO.save(instructor);
	}
}
