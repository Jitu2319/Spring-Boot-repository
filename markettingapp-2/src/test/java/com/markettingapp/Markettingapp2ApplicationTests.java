package com.markettingapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.markettingapp.entities.Student;
import com.markettingapp.repositories.StudentRepository;

@SpringBootTest
class Markettingapp2ApplicationTests {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveOneStudentRecord() {
		Student s = new Student();
		s.setId(2);
		s.setName("Rahul");
		s.setCourse("CSS");
		s.setFee(100);
		studentRepo.save(s);
	}

//
//	@Test
//	void deleteOneStudentRecord() {
//		studentRepo.deleteById(1L);
//
//	}
	@Test
	void findOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());

	}

	@Test
	void updateOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(1L);
		Student student = findById.get();
		student.setCourse("Html");
		studentRepo.save(student);
	}
}
