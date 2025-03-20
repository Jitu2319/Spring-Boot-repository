package Misroservices.service;

import java.util.*;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Misroservices.entities.Hotel;
import Misroservices.entities.Rating;
import Misroservices.entities.User;
import Misroservices.exceptions.ResourceNotFoundException;
import Misroservices.external.services.HotelService;
import Misroservices.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		userRepo.save(user);
		return user;
	}

	@Override
	public User getUserById(String userid) {
		User user = userRepo.findById(userid).orElseThrow(() -> new ResourceNotFoundException(
				"User with given id is not found. Please try with a different id."));

		// Fetch ratings with the help of RestTemplate client
		Rating[] userRatingsArray = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + userid,
				Rating[].class);
		logger.info("{} ", userRatingsArray);

		List<Rating> ratingList = Arrays.stream(userRatingsArray).map(rating -> {
			// Calling the hotel service to get the data
//			ResponseEntity<Hotel> forEntity = restTemplate
//					.getForEntity("http://Hotel-Service/hotels/" + rating.getHotelId(), Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
//			Hotel hotel = forEntity.getBody();
//			logger.info("Response status code: " + forEntity.getStatusCodeValue());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());

		user.setRatings(ratingList); // Set the enhanced ratings list, not the original userRatingsArray
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userRepo.findAll();

		// Will do it later for get all rating with respective users.
		return users;
	}

}
