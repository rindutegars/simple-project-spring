package com.example.tiket_renang.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SalesResponseDTO {
    private int totalTickets;
    private String totalPrice;
    private String message;
}
