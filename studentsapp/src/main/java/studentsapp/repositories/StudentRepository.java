package studentsapp.repositories;

import org.springframework.data.repository.CrudRepository;

import studentsapp.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
