package com.Flight_Reservation_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Flight_Reservation_app.dto.ReservationRequest;
import com.Flight_Reservation_app.entity.Reservation;
import com.Flight_Reservation_app.service.ReservationService;
import com.Flight_Reservation_app.utilities.PDFgenerator;

@Controller
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("/confirmReservation")
	public String confirmReservation(ReservationRequest request, ModelMap model) {
		Reservation reservationId = reservationService.bookFlight(request);
		model.addAttribute("reservationId", reservationId.getId());
		
		return "confirmreservation";

	}

}
