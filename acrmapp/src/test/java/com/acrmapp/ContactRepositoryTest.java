package com.acrmapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.acrmapp.entity.Lead;
import com.acrmapp.repository.ContactRepository;
import com.acrmapp.repository.LeadRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ContactRepositoryTest {

	@Autowired
	private ContactRepository contactRepo;

	@Test
	public void saveOneLead() {
	}

}
