package com.example.restaurantreservation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservationResponseDTO {
    private String day;
    private String customers;
}
