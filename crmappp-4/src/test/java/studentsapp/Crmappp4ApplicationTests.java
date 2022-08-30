package studentsapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import studentsapp.entites.Student;
import studentsapp.repositories.studentrepository;

@SpringBootTest
class Crmappp4ApplicationTests {
	
	@Autowired
	private studentrepository studentrepo;
	
	@Test
	void saverecord() {
		Student s = new Student();
		s.setName("Peter");
		s.setCourse("Web development");
		s.setFee(100000);
		studentrepo.save(s);
	}
	@Test
	void deleterecord() {
		studentrepo.deleteById(12l);
	}
	@Test
	void findrecord() {
		Optional<Student> findById = studentrepo.findById(10l);
		Student student = findById.get();
		System.out.println(student.getId());
		System.out.println(student.getName());
		System.out.println(student.getCourse());
		System.out.println(student.getFee());
	}
	@Test
	void updaterecord() {
		Optional<Student> findById = studentrepo.findById(10l);
		Student student = findById.get();
		student.setName("Web");
		studentrepo.save(student);
	}

}
