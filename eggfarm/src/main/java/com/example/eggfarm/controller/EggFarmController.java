package com.example.eggfarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.eggfarm.DTO.request.EggInputRequestDTO;
import com.example.eggfarm.DTO.response.EggSalesResponseDTO;
import com.example.eggfarm.service.EggInputService;
import com.example.eggfarm.service.EggSummaryService;

@RestController
@RequestMapping("/api/egg-farm")
public class EggFarmController {

    @Autowired
    private EggInputService eggInputService;

    @Autowired
    private EggSummaryService eggSummaryService;

    @PostMapping("/add-eggs")
    public EggSalesResponseDTO addEggs(@RequestBody EggInputRequestDTO requestDTO) {
        return eggInputService.addEggs(requestDTO);
    }

    @GetMapping("/sales-summary")
    public EggSalesResponseDTO getSalesSummary() {
        return eggSummaryService.getSalesSummary();
    }
}
