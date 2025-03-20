package net.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.UserRepository;
import net.engineeringdigest.journalApp.Services.UserDetailServiceImpl;

public class TestUserDetailsServiceImpl {

	@InjectMocks
	private UserDetailServiceImpl userImpl;

	@Mock
	private UserRepository userRepo;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testLoadByUserName() {
		when(userRepo.findByUserName(ArgumentMatchers.anyString()))
				.thenReturn(Users.builder().userName("Jitendra").password("Jitendra").roles(new ArrayList<>()).build());
		UserDetails user = userImpl.loadUserByUsername("Jitendra");
		assertNotNull(user);

	}

}
