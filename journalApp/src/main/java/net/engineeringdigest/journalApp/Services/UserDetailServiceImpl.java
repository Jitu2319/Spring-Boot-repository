package net.engineeringdigest.journalApp.Services;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import net.engineeringdigest.journalApp.Model.Users;
import net.engineeringdigest.journalApp.Repository.UserRepository;

@Component
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Users user = userRepo.findByUserName(userName);

		if (user != null) {
			UserDetails userDetail = org.springframework.security.core.userdetails.User.builder()
					.username(user.getUserName()).password(user.getPassword())
					.roles(user.getRoles().toArray(new String[0])).build();
			return userDetail;

		}

		throw new UsernameNotFoundException("User not found with User name :" + userName);
	}

}
