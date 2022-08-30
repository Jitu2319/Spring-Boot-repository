package studentsapp.repository;

import org.springframework.data.repository.CrudRepository;

import studentsapp.Entity.students;

public interface StudentRepository extends CrudRepository<students, Long> {

}
