package com.Flight_Reservation_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Flight_Reservation_app.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
