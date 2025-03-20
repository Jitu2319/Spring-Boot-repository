package hotelService.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hotelService.Repository.HotelRepository;
import hotelService.entities.Hotel;
import hotelService.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String randomId = UUID.randomUUID().toString();
		hotel.setId(randomId);
		return hotelRepo.save(hotel);
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		return hotelRepo.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("Hotel of given id is not found"));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

}
