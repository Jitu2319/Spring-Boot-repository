package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.api.SoftAssertionsRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Services.UserService;

@SpringBootTest
public class TestUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserService userService;

	@ParameterizedTest
	@ValueSource(strings = { "jitendra", "Ram", "Jk" })
	public void testFindbyUserName(String name) {

		assertNotNull(userRepo.findByUserName(name));
		assertNotNull(userRepo.findByUserName("Jk"));

		Users user = userRepo.findByUserName("Jk");
		assertTrue(!user.getPassword().isEmpty());

		assertEquals(2, 1 + 1);
	}

	@ParameterizedTest
	@CsvSource({ "1,2,3", "2,2,4" })
	public void test(int a, int b, int expected) {

		assertEquals(expected, a + b);
	}

	@ParameterizedTest
	@ArgumentsSource(UserArgumentSource.class)
	public void testCustomFindbyUserName(Users user) {

		assertTrue(userService.saveEntry(user));

	}

}
