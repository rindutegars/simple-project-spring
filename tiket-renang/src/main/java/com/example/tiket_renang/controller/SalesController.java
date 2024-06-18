package com.example.tiket_renang.controller;

import com.example.tiket_renang.DTO.request.SellRequestDTO;
import com.example.tiket_renang.DTO.response.SalesResponseDTO;
import com.example.tiket_renang.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SalesController {

    private final SalesService salesService;

    @Autowired
    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @PostMapping("/sell-tickets")
    public SalesResponseDTO sellTickets(@RequestBody SellRequestDTO requestDTO) {
        return salesService.sellTickets(requestDTO.getQuantity());
    }

    @GetMapping("/sales-summary")
    public SalesResponseDTO getSalesSummary() {
        return salesService.getSalesSummary();
    }
}
