package com.example.eggfarm.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class EggSalesResponseDTO {
    private int totalEggs;
    private int totalIncome;
    private String message;
}
