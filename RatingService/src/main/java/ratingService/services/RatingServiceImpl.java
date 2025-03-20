package ratingService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ratingService.entities.Rating;
import ratingService.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepo;

	@Override
	public Rating createRating(Rating rating) {

		String randomRatingId = UUID.randomUUID().toString();
		rating.setRatingId(randomRatingId);
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserId(String ratingId) {
		return ratingRepo.getByUserId(ratingId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingRepo.getByHotelId(hotelId);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepo.findAll();
	}

}
