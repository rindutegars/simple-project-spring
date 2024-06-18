package com.example.tiket_renang.service;

import com.example.tiket_renang.DTO.response.SalesResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class SalesService {

    private int totalSales = 0;
    private int totalTicketsSold = 0;

    public SalesResponseDTO sellTickets(int quantity) {
        int pricePerTicket = 10000;
        int totalPrice = pricePerTicket * quantity;
        totalSales += totalPrice;
        totalTicketsSold += quantity;

        SalesResponseDTO responseDTO = new SalesResponseDTO();
        responseDTO.setTotalTickets(quantity);
        responseDTO.setTotalPrice("Rp. " + totalPrice);
        responseDTO.setMessage("Penjualan telah berhasil ditambahkan. Jumlah tiket: " + quantity
                + ". Total pembayaran: Rp. " + totalPrice);

        return responseDTO;
    }

    public SalesResponseDTO getSalesSummary() {
        SalesResponseDTO summaryDTO = new SalesResponseDTO();
        summaryDTO.setTotalTickets(totalTicketsSold);
        summaryDTO.setTotalPrice("Rp. " + totalSales);
        summaryDTO.setMessage("Data Load Successfully");
        return summaryDTO;
    }
}
