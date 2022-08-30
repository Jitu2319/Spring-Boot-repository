package com.TestProject.repositories;

import org.springframework.data.repository.CrudRepository;

import com.TestProject.entities.Student;

public interface StudentRepositry extends CrudRepository<Student, Long> {

}
