package com.TestProject;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.TestProject.entities.Student;
import com.TestProject.repositories.StudentRepository;

@SpringBootTest
class TestProject1ApplicationTests {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveOneLead() {
		Student s = new Student();
		s.setName("Jitendra");
		s.setCourse("java");
		s.setFee(1000);
		studentRepo.save(s);
	}

	@Test
	void deleteOneLead() {
		studentRepo.deleteById(2L);
	}

	@Test
	void findOneLead() {
		Optional<Student> findById = studentRepo.findById(3L);
		Student student = findById.get();
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}

	@Test
	void updateOneLead() {

	}
}
