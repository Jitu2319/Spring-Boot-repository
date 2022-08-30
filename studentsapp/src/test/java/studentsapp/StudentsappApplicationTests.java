package studentsapp;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import studentsapp.entities.Student;
import studentsapp.repositories.StudentRepository;

@SpringBootTest
class StudentsappApplicationTests {

	@Autowired
	private StudentRepository studentRepo;

	@Test
	void saveOneStudentRecord() {
		Student s = new Student();
		s.setName("Mike");
		s.setCourse("java");
		s.setFee("2000");

		studentRepo.save(s);

	}

	@Test
	void deleteOneRecord() {
//		studentRepo.deleteById(2L);
	}

//	@Test
//	void findOneStudentRecord() {
//		Optional<Student> findById = studentRepo.findById(3L);
//		Student student = findById.get();
//		System.out.println(student.getId());
//		System.out.println(student.getName());
//		System.out.println(student.getCourse());
//		System.out.println(student.getFee());

//	}

	@Test
	void updateOneStudentRecord() {
		Optional<Student> findById = studentRepo.findById(3L);
		Student student = findById.get();
		student.setCourse("css");
		studentRepo.save(student);
	}

}
