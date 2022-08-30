package com.crmapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmapp.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
