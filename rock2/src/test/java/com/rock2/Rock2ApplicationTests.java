package com.rock2;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rock2.entities.student;
import com.rock2.repositories.StudentRepository;

@SpringBootTest
class Rock2ApplicationTests {
	@Autowired
	private StudentRepository studentRepo;

//	@Test
//	void saveOneStudentRecord() {
//		student s = new student();
//		s.setName("jitendra");
//		s.setCourse("Java");
//		s.setFee("2000");
//		studentRepo.save(s);
		
//	}
//		@Test
//			void deleteOneStudentRecord() {
//			studentRepo.deleteById(3L);
//			studentRepo.deleteById(4L);
//			studentRepo.deleteById(5L);
//			studentRepo.deleteById(6L);
//			studentRepo.deleteById(7L);
//		}
		@Test
		void findOneStudentRecord() {
			Optional<student> findById = studentRepo.findById(8L);
			student student = findById.get(); 
			System.out.println(student.getCourse());
			System.out.println(student.getFee());
			System.out.println(student.getId());
			System.out.println(student.getName());
		}
		@Test
		void updateOneStudentRecord() {
			Optional<student> findById = studentRepo.findById(8L);
			student student = findById.get(); 
			student.setFee("5000");
			studentRepo.save(student);
		}
}
