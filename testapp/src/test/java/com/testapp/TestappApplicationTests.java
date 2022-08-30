package com.testapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.testapp.Entity.student;
import com.testapp.repository.StudentRepository;

@SpringBootTest
class TestappApplicationTests {
	@Autowired
	private StudentRepository studentrepo;

	@Test
	void save() {
		student s = new student();
		s.setName("Kenya");
		s.setEmail("Kenya@gmail.com");
		s.setCity("New york");
		s.setMobile("9853234221");
		studentrepo.save(s);
	}

	@Test
	void delete() {
		studentrepo.deleteById(2L);
	}

	@Test
	void getrecord() {
		Optional<student> findById = studentrepo.findById(3L);
		student student = findById.get();
		System.out.println(student.getName());
		System.out.println(student.getEmail());
		System.out.println(student.getCity());
		System.out.println(student.getMobile());
	}

	@Test
	void update() {
		Optional<student> findById = studentrepo.findById(3L);
		student student = findById.get();
		student.setCity("Europe");
		studentrepo.save(student);
	}
}
