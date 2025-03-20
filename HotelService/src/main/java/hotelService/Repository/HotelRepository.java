package hotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hotelService.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {

}
