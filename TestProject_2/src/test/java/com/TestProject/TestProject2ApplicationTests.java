package com.TestProject;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TestProject.entities.Student;
import com.TestProject.repositories.StudentRepositry;

@SpringBootTest
class TestProject2ApplicationTests {

	@Autowired
	private StudentRepositry studentRepo;

	@Test
	void saveOneRecord() {
		Student s = new Student();
		s.setName("Pankaj");
		s.setCourse("Maths");
		s.setFee(1000);
		studentRepo.save(s);
		System.out.println(s);
	}

	@Test
	void deleteOneRecord() {
		studentRepo.deleteById(4l);
		studentRepo.deleteById(5l);
		studentRepo.deleteById(6l);
	}

	@Test
	void findOneRecord() {
		Optional<Student> findById = studentRepo.findById(3L);
		Student students = findById.get();
		System.out.println(students.getId());
		System.out.println(students.getName());
		System.out.println(students.getCourse());
		System.out.println(students.getFee());

	}

	@Test
	void updateOneRecord() {
		Optional<Student> findById = studentRepo.findById(3L);
		Student students = findById.get();
		students.setCourse("Science");
		students.setFee(1000000000);
		studentRepo.save(students);
	}

}
