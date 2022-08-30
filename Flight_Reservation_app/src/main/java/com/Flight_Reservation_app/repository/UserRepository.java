package com.Flight_Reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}