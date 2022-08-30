package com.crmappp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crmappp.entity.Lead;
import com.crmappp.repositories.BillingRepository;
import com.crmappp.repositories.ContactRepository;
import com.crmappp.repositories.LeadRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class BillingRepositoryTest {
	
	@Autowired
	private BillingRepository billingRepo;
	
	@Test
	public void saveOneBill() {
		

	}

}
