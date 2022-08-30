package com.rock2.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rock2.entities.student;

public interface StudentRepository extends CrudRepository<student, Long> {

}
