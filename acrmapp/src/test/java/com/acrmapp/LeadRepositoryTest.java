package com.acrmapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.acrmapp.entity.Lead;
import com.acrmapp.repository.LeadRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class LeadRepositoryTest {

	@Autowired
	private LeadRepository leadrepo;

	@Test
	public void saveOneLead() {
		Lead l = new Lead("Mike", "m", "mike@gmail.com", "Newspaper", "92384424");
		leadrepo.save(l);
	}

}
