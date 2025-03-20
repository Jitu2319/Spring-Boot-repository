package com.ExamServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ExamServer.model.user;

public interface UserRepository extends JpaRepository<user, Long> {

	void save(user user);

}
