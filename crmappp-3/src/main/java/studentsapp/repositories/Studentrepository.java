package studentsapp.repositories;

import org.springframework.data.repository.CrudRepository;

import studentsapp.entities.students;

public interface Studentrepository extends CrudRepository<students, Long> {

}
