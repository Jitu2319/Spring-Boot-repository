package studentsapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import studentsapp.Entity.students;
import studentsapp.repository.StudentRepository;

@SpringBootTest
class Crmappp2ApplicationTests {
	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveonestudentrecord() {
		students s = new students();
		s.setName("Jitendra");
		s.setCourse("Java");
		s.setFee(4000);
		studentRepo.save(s);
	}
	@Test
	void deleteonestudencord() {
		studentRepo.deleteById(2l);
	}
	@Test	
	void findonestudentrecord() {
		Optional<students> findById = studentRepo.findById(10L);
		students students = findById.get();
		System.out.println(students.getId());
		System.out.println(students.getName());
		System.out.println(students.getCourse());
		System.out.println(students.getFee());
		
	}
	@Test	
	void updateonestudentrecord() {
		Optional<students> findById = studentRepo.findById(10L);
		students students = findById.get();
		students.setName("Rohit");
		studentRepo.save(students);
	}
}
