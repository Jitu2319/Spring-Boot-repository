package studentsapp.repositories;

import org.springframework.data.repository.CrudRepository;

import studentsapp.entites.Student;

public interface studentrepository extends CrudRepository<Student, Long> {

}
