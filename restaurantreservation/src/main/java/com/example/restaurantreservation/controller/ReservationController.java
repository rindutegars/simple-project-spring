package com.example.restaurantreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.restaurantreservation.dto.request.ReservationRequestDTO;
import com.example.restaurantreservation.dto.response.ReservationResponseDTO;
import com.example.restaurantreservation.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping("/reserve")
    public ReservationResponseDTO reserve(@RequestBody ReservationRequestDTO requestDTO) {
        return reservationService.reserve(requestDTO);
    }

    @GetMapping("/weekly")
    public List<ReservationResponseDTO> getWeeklyReservations() {
        return reservationService.getWeeklyReservations();
    }
}
