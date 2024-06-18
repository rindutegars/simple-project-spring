package com.example.eggfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eggfarm.data.EggFarmData;
import com.example.eggfarm.DTO.response.EggSalesResponseDTO;

@Service
public class EggSummaryService {

    @Autowired
    private EggFarmData eggFarmData;

    public EggSalesResponseDTO getSalesSummary() {
        return new EggSalesResponseDTO(
                eggFarmData.getTotalEggs(),
                eggFarmData.getTotalIncome(),
                "Data Loaded Successfully");
    }
}
