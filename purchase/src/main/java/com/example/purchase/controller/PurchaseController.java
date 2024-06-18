package com.example.purchase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.purchase.dto.request.PurchaseRequestDTO;
import com.example.purchase.dto.response.PurchaseResponseDTO;
import com.example.purchase.service.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping
    public PurchaseResponseDTO findBestPurchase(@RequestBody PurchaseRequestDTO request) {
        return purchaseService.findBestPurchase(request);
    }
}
