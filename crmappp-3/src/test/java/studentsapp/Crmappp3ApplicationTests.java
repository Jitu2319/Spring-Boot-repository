package studentsapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import studentsapp.entities.students;
import studentsapp.repositories.Studentrepository;

@SpringBootTest
class Crmappp3ApplicationTests {
	@Autowired
	private Studentrepository studentrepo;

	@Test
	void saveonestudentrecord(){
		students s = new students();
		s.setName("Rakhi");
		s.setCourse("Neet");
		s.setFee(60000);
		studentrepo.save(s);
	}
	@Test
	void deleteonestudentrecord() {
		studentrepo.deleteById(11l);
	}
	@Test
	void findonestudentrecord() {
		Optional<students> findById = studentrepo.findById(10l);
		students students = findById.get();
		System.out.println(students.getId());
		System.out.println(students.getName());
		System.out.println(students.getCourse());
		System.out.println(students.getFee());
	}
	@Test
	void updateonestudentrecord() {
		Optional<students> findById = studentrepo.findById(10l);
		students students = findById.get();
		students.setName("Billinair");
		studentrepo.save(students);
	}

}
