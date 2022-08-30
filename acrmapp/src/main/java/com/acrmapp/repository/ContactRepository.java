package com.acrmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acrmapp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
