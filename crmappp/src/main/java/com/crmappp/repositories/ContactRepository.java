package com.crmappp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmappp.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
