package studentsapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import studentsapp.entity.students;
import studentsapp.repository.Studentsrepository;

@SpringBootTest
class Crmappp1ApplicationTests {

	@Autowired
	private Studentsrepository studentRepo;

	@Test
	void saveonestudentrecord() {
		students s = new students();
		s.setName("Darcel");
		s.setCourse("java");
		s.setFee(500);
		studentRepo.save(s);
	}

	@Test
	void deleteonerecord() {
		studentRepo.deleteById(1L);

	}
	@Test
	void findonestudentrecord() {
		Optional<students> findById = studentRepo.findById(3L);
		students students = findById.get();
		System.out.println(students.getId());
		System.out.println(students.getName());
		System.out.println(students.getCourse());
		System.out.println(students.getFee());
	}
	@Test
	void updateonestudentrecord() {
		Optional<students> findById = studentRepo.findById(3L);
		students students = findById.get();
		students.setCourse("maths");
		studentRepo.save(students);
	}
	

}
