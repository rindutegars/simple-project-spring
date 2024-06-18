package com.example.purchase.service;

import org.springframework.stereotype.Service;

import com.example.purchase.dto.request.PurchaseRequestDTO;
import com.example.purchase.dto.response.PurchaseResponseDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PurchaseService {

    private List<Integer> keyboardPrices = Arrays.asList(20000, 40000, 50000);
    private List<Integer> mousePrices = Arrays.asList(12000, 20000, 35000);

    public PurchaseResponseDTO findBestPurchase(PurchaseRequestDTO request) {
        int amount = request.getAmount();
        List<String> bestCombination = new ArrayList<>();
        int bestTotal = 0;

        for (int keyboardPrice : keyboardPrices) {
            for (int mousePrice : mousePrices) {
                int total = keyboardPrice + mousePrice;
                if (total <= amount && total > bestTotal) {
                    bestTotal = total;
                    bestCombination = new ArrayList<>(
                            Arrays.asList("Keyboard: Rp. " + keyboardPrice, "Mouse: Rp. " + mousePrice));
                }
            }
        }

        PurchaseResponseDTO responseDTO = new PurchaseResponseDTO();
        responseDTO.setItems(bestCombination);
        responseDTO.setTotalSpent(bestTotal);
        responseDTO.setMessage("Pembelian terbaik yang bisa dilakukan dengan uang Rp. " + amount);

        return responseDTO;
    }
}
