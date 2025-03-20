package ratingService.services;

import java.util.*;

import ratingService.entities.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);

	public List<Rating> getRatingByUserId(String ratingId);

	public List<Rating> getRatingByHotelId(String hotelId);

	public List<Rating> getAllRating();

}
