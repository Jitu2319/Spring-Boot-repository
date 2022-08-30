package com.markettingapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.markettingapp.entities.Student;
import com.markettingapp.repositories.StudentRepository;

@SpringBootTest
class Markettingapp1ApplicationTests {

	@Autowired
	private StudentRepository studentRepo;
//
//	@Test
//	void saveOneStudentRecord() {
//		Student s = new Student();
//		s.setName("Jite");
//		s.setCourse("java");
//		s.setFee("1000");
//		studentRepo.save(s);
//
//	}
//	@Test
//	void deleteOneStudentRecord() {
//		studentRepo.deleteById(10L);
//		
//	}
	@Test
	void findOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(11L);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
		
		
	}
	@Test
	void updateOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(11L);
		Student student = findById.get();
		student.setFee("300");
		studentRepo.save(student);
	}
	

}
