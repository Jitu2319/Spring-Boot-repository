package com.crmapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crmapp.entities.Lead;
import com.crmapp.repository.LeadRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LeadRepositoryTest {

	@Autowired
	private LeadRepository leadRepo;

	@Test
	public void saveOneLead() {
		Lead l = new Lead("Katrina", "sain", "katrina@gmail.com", "TV", "8743808439");
		leadRepo.save(l);
	}

}
