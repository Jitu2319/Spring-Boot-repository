package hotelService.services;

import java.util.*;


import hotelService.entities.Hotel;

public interface HotelService {
	
	public Hotel createHotel(Hotel hotel);
	
	public Hotel getHotelById(String hotelId);
	
	public List<Hotel> getAllHotels();

}
