package com.example.restaurantreservation.service;

import org.springframework.stereotype.Service;
import com.example.restaurantreservation.dto.request.ReservationRequestDTO;
import com.example.restaurantreservation.dto.response.ReservationResponseDTO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {

    private Map<LocalDate, List<String>> reservations = new HashMap<>();
    private LocalDate nextAvailableDate = LocalDate.now().with(DayOfWeek.MONDAY);

    public ReservationResponseDTO reserve(ReservationRequestDTO request) {
        String customerName = request.getCustomerName();
        LocalDate reservationDate = findNextAvailableDate();

        reservations.putIfAbsent(reservationDate, new ArrayList<>());
        reservations.get(reservationDate).add(customerName);

        return new ReservationResponseDTO(reservationDate.getDayOfWeek().toString(), customerName);
    }

    public List<ReservationResponseDTO> getWeeklyReservations() {
        List<ReservationResponseDTO> response = new ArrayList<>();
        LocalDate startOfWeek = LocalDate.now().with(DayOfWeek.MONDAY);

        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfWeek.plusDays(i);
            DayOfWeek dayOfWeek = date.getDayOfWeek();
            String customers;

            if (isHoliday(dayOfWeek)) {
                customers = "Libur";
            } else {
                List<String> customerList = reservations.getOrDefault(date, new ArrayList<>());
                if (customerList.isEmpty()) {
                    customers = "Tidak ada reservasi";
                } else {
                    customers = String.join(", ", customerList);
                }
            }

            response.add(new ReservationResponseDTO(dayOfWeek.toString(), customers));
        }
        return response;
    }

    private LocalDate findNextAvailableDate() {
        while (true) {
            if (isHoliday(nextAvailableDate.getDayOfWeek()) || isFullyBooked(nextAvailableDate)) {
                nextAvailableDate = nextAvailableDate.plusDays(1);
            } else {
                break;
            }
        }
        return nextAvailableDate;
    }

    private boolean isHoliday(DayOfWeek day) {
        return day == DayOfWeek.FRIDAY || day == DayOfWeek.WEDNESDAY;
    }

    private boolean isFullyBooked(LocalDate date) {
        return reservations.getOrDefault(date, new ArrayList<>()).size() >= 2;
    }
}
