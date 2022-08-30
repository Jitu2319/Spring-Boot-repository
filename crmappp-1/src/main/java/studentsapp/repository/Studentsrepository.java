package studentsapp.repository;

import org.springframework.data.repository.CrudRepository;

import studentsapp.entity.students;

public interface Studentsrepository extends CrudRepository<students, Long> {

}
