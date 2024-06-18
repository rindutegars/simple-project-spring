package com.example.eggfarm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.eggfarm.data.EggFarmData;
import com.example.eggfarm.DTO.request.EggInputRequestDTO;
import com.example.eggfarm.DTO.response.EggSalesResponseDTO;

@Service
public class EggInputService {

    @Autowired
    private EggFarmData eggFarmData;

    public EggSalesResponseDTO addEggs(EggInputRequestDTO requestDTO) {
        int quantity = requestDTO.getQuantity();
        eggFarmData.addEggs(quantity);

        int totalPrice = quantity * EggFarmData.PRICE_PER_EGG;
        return new EggSalesResponseDTO(
                eggFarmData.getTotalEggs(),
                eggFarmData.getTotalIncome(),
                "Input ayam bertelur berhasil. Total telur: " + eggFarmData.getTotalEggs() + ". Total penghasilan: Rp. "
                        + eggFarmData.getTotalIncome());
    }
}
