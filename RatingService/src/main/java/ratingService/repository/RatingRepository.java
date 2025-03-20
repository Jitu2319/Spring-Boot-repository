package ratingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ratingService.entities.Rating;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> getByUserId(String ratingId);

	List<Rating> getByHotelId(String hotelId);

}
