package hotelService.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
		super("hotel of this given id is not found.");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
