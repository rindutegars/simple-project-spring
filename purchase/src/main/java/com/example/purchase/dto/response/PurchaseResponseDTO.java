package com.example.purchase.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PurchaseResponseDTO {
    private String message;
    private List<String> items;
    private int totalSpent;
}
