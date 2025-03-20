package Misroservices.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Misroservices.entities.User;

@Service
public interface UserService {

	//To save the users
	public User saveUser(User user);

	public List<User> getAllUsers();

	public User getUserById(String userid);
}
