package com.testapp.repository;

import org.springframework.data.repository.CrudRepository;

import com.testapp.Entity.student;

public interface StudentRepository extends CrudRepository<student, Long> {

}
