package com.markettingapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.markettingapp.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
